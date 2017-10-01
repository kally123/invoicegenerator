package com.mc.pdfgenerate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.domain.Customer;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.enumtype.AccomidationType;

/**
 * @author Dinesh R
 */

public class GeneratePdf {

	public void main(String[] args)
			throws IOException, DocumentException, IllegalArgumentException, IllegalAccessException {
		CustomerBooking customerBooking = new CustomerBooking();
		populateDummyData(customerBooking);
		new GeneratePdf().generatePdf(customerBooking, "Untitled 1.pdf", "CustomerInvoice.pdf");
	}

	public void generatePdf(CustomerBooking customerBooking, String templateName, String outputPdf) {
		PdfReader pdfTemplate = null;
		PdfStamper stamper = null;
		try {
			System.out.println(customerBooking.toString() + " Invoice is getting generated..");
			pdfTemplate = new PdfReader(templateName);
			FileOutputStream fileOutputStream = new FileOutputStream(outputPdf);
			stamper = new PdfStamper(pdfTemplate, fileOutputStream);
			stamper.setFormFlattening(true);

			printContents(stamper, customerBooking.getAccomidation());
			printContents(stamper, customerBooking.getCustomer());
			printContents(stamper, customerBooking);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				stamper.close();
				pdfTemplate.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void printContents(PdfStamper stamper, Object obj)
			throws IllegalArgumentException, IllegalAccessException, IOException, DocumentException {

		for (Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value = field.get(obj);
			if (value != null) {
				stamper.getAcroFields().setField(field.getName(), value.toString());
			}
		}
	}

	private void populateDummyData(CustomerBooking customerBooking) {
		Accomidation a = new Accomidation();
		a.setAccomidationType(AccomidationType.SingleRoom);
		a.setPrice(1000);
		customerBooking.setAccomidation(a);
		customerBooking.setNoOfDays(2);
		Customer customer = new Customer();
		customer.setCustomerName("Kalyan");
		customerBooking.setCustomer(customer);
	}
}

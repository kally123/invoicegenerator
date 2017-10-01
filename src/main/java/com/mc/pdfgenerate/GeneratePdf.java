package com.mc.pdfgenerate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

	private static Customer customer = new Customer();

	public static void main(String[] args)
			throws IOException, DocumentException, IllegalArgumentException, IllegalAccessException {
		new GeneratePdf().generatePdf("Untitled 1.pdf", "CustomerInvoice.pdf");
	}

	private static void generatePdf(String templateName, String outputPdf) throws IOException, FileNotFoundException,
			DocumentException, IllegalArgumentException, IllegalAccessException {
		populateDummyData();
		PdfReader pdfTemplate = new PdfReader(templateName);
		FileOutputStream fileOutputStream = new FileOutputStream(outputPdf);
		PdfStamper stamper = new PdfStamper(pdfTemplate, fileOutputStream);
		stamper.setFormFlattening(true);
		List<Class> classes = new ArrayList<>();
		classes.add(Customer.class);
		classes.add(Accomidation.class);
		classes.add(CustomerBooking.class);
		printContents(stamper, customer);
		// stamper.getAcroFields().setField("id", "1\n2\n3\n");
		// stamper.getAcroFields().setField("friendname",
		// "kumar\nsirisha\nsuresh\n");
		// stamper.getAcroFields().setField("relation", "self\nwife\nfriend\n");

		stamper.close();
		pdfTemplate.close();

	}

	private static void printContents(PdfStamper stamper, Object obj)
			throws IllegalArgumentException, IllegalAccessException, IOException, DocumentException {

		for (Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value = field.get(obj);
			if (value != null) {
				if (value instanceof Accomidation || value instanceof CustomerBooking) {
					printContents(stamper, value);
				} else {
					stamper.getAcroFields().setField(field.getName(), value.toString());
					System.out.println(field.getName() + "/" + value.toString());
				}
			}
		}
	}

	private static void populateDummyData() {
		customer.setCustomerName("Kalyan");
		CustomerBooking customerBooking = new CustomerBooking();
		Accomidation a = new Accomidation();
		a.setAccomidationType(AccomidationType.SingleRoom);
		a.setPrice(1000);
		customerBooking.setAccomidation(a);
		customerBooking.setNoOfDays(2);
		customer.setCustomerBooking(customerBooking);
	}
}

package com.mc.pdfgenerate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.mc.invoice.InvoicegeneratorApplication;
import com.mc.invoice.domain.CustomerBooking;

/**
 * @author Kalyan
 */

public class GeneratePdf {

	private static GeneratePdf generatePdf = null;

	public static GeneratePdf getInstance() {
		if (generatePdf == null) {
			generatePdf = new GeneratePdf();
		}
		return generatePdf;
	}

	private String getFilePath() {
		File jarPath = new File(
				InvoicegeneratorApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.println("jarPath.getParent() : " + jarPath.getParent());
		String folderPath = jarPath.getPath().contains("jar") ? jarPath.getParentFile().getParentFile().getParent()
				: jarPath.getParentFile().getParentFile().getAbsolutePath();
		if (System.getProperty("os.name").toLowerCase().indexOf("mac") > -1) {
			folderPath = folderPath.replace("file:", "");
		}
		System.out.println("propertiesPath :" + folderPath);
		return folderPath;
	}

	public void generatePdf(CustomerBooking customerBooking, String templateName, String outputPdf) {
		PdfReader pdfTemplate = null;
		PdfStamper stamper = null;
		try {
			System.out.println(customerBooking.toString() + " Invoice for "
					+ customerBooking.getCustomer().getCustomerName() + " is getting generated..");

			pdfTemplate = new PdfReader(templateName);
			FileOutputStream fileOutputStream = new FileOutputStream(
					new File(getFilePath() + File.separatorChar + outputPdf));
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
				// System.out.println(field.getName() + "/" + value.toString());
			}
		}
	}

}

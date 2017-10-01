package com.mc.pdfgenerate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.domain.Customer;
import com.mc.invoice.domain.CustomerBooking;

/**
 * @author Dinesh R
 */

public class GeneratePdf {

	private static Customer customer = new Customer();
	private static CustomerBooking customerBooking = new CustomerBooking();
	private static Accomidation accomidation = new Accomidation();
	private static double totalPrice;

	public static void main(String[] args) throws IOException, DocumentException {
		new GeneratePdf().generatePdf("Untitled 1.pdf", "CustomerInvoice.pdf");
	}

	private static void generatePdf(String templateName, String outputPdf)
			throws IOException, FileNotFoundException, DocumentException {
		PdfReader pdfTemplate = new PdfReader(templateName);
		FileOutputStream fileOutputStream = new FileOutputStream(outputPdf);
		PdfStamper stamper = new PdfStamper(pdfTemplate, fileOutputStream);
		stamper.setFormFlattening(true);

		stamper.getAcroFields().setField("customerName", "Kalyan");
		// stamper.getAcroFields().setField("id", "1\n2\n3\n");
		// stamper.getAcroFields().setField("friendname",
		// "kumar\nsirisha\nsuresh\n");
		// stamper.getAcroFields().setField("relation", "self\nwife\nfriend\n");

		stamper.close();
		pdfTemplate.close();

	}
}

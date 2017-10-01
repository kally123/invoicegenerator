package com.mc.pdfgenerate;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.domain.Customer;
import com.mc.invoice.domain.CustomerBooking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Dinesh R
 */

public class GeneratePdf {
	public static final String DEST = "D:/Projects/Subscription.pdf";
	private static Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLUE);
	private static Customer customer = new Customer();
	private static CustomerBooking customerBooking = new CustomerBooking();
	private static Accomidation accomidation = new Accomidation();
	private static double totalPrice;

	public static void main(String[] args) throws IOException, DocumentException {
		accomidation.setPrice(123);
		customer.setId(36L);
		customer.setCustomerName("Dinesh");
		customerBooking.setNoOfDays(12);
		customerBooking.setCustomer(customer);

		totalPrice = customerBooking.getNoOfDays() * accomidation.getPrice();
		customerBooking.setTotalPrice((int) totalPrice);

		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new GeneratePdf().createPdf(DEST);

	}

	public void createPdf(String dest) throws IOException, DocumentException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();
		
		Image img = Image.getInstance("src/main/resources/static/public/img/invoice.png");
	//  img.setAbsolutePosition(0f, 0f);  
       // document.add(img);
		
		
		
		Rectangle column = new Rectangle(36, 36, 559, 806);
		ColumnText ct = new ColumnText(writer.getDirectContent());
		ct.setSimpleColumn(column);
		for (int i = 0; i < 1; i++) {
			PdfPTable table = new PdfPTable(new float[] { 0.25f, 0.25f, 0.25f, 0.25f });
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.setWidthPercentage(100);
			PdfPCell cell = new PdfPCell(new Phrase("Customer Invoice"));
			img.scalePercent(30);
			//img.setAbsolutePosition(0f, 0f);
			cell.addElement(img);
			cell.setColspan(4);
			table.addCell(cell);
			// header in table

			Phrase phrase = new Phrase();
			phrase.add(new Chunk("Id", blueFont));
			table.addCell(phrase);

			Phrase phrase1 = new Phrase();
			phrase1.add(new Chunk("Customer Name", blueFont));
			table.addCell(phrase1);

			Phrase phrase2 = new Phrase();
			phrase2.add(new Chunk("NoOfDays", blueFont));
			table.addCell(phrase2);

			Phrase phrase3 = new Phrase();
			phrase3.add(new Chunk("TotalPrice", blueFont));

			table.addCell(phrase3);

			table.setHeaderRows(1);

			table.addCell(new Phrase(String.valueOf(customerBooking.getCustomer().getId())));
			table.addCell(new Phrase(customerBooking.getCustomer().getCustomerName()));
			table.addCell(new Phrase(String.valueOf(customerBooking.getNoOfDays())));
			table.addCell(new Phrase(String.valueOf(customerBooking.getTotalPrice())));
			ct.addElement(table);
			if (ColumnText.hasMoreText(ct.go())) {
				document.newPage();
				ct = new ColumnText(writer.getDirectContent());
				ct.setSimpleColumn(column);
			}
		}
		document.close();
	}
}
package com.assignment.DonationApp.services;

import com.assignment.DonationApp.Donation;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class DocumentServiceIml implements DocumentService {



    @Override
    public boolean createPDF(List<Donation> donationList, ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        Document document = new Document(PageSize.A4, 15 ,  15, 45, 30);
        try{
            String filePath = servletContext.getRealPath("/resources");
            File file = new File(filePath);
            boolean exists = new File(filePath).exists();
            if(!exists){

                new File(filePath).mkdirs();
            }

            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(file+ "/" + "donationList" +".pdf"));
            document.open();

            Font mainFont = FontFactory.getFont("Arial",10, BaseColor.BLACK);

            Paragraph paragraph = new Paragraph("All Donations",mainFont);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setIndentationLeft(50);
            paragraph.setIndentationRight(50);
            paragraph.setSpacingAfter(10);
            document.add(paragraph);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10);

            Font tableHeader = FontFactory.getFont("Arial",10, BaseColor.BLACK);
            Font tableBody = FontFactory.getFont("Arial",9, BaseColor.BLACK);

            float[] columnWithds = {2f, 2f,2f,2f};
            table.setWidths(columnWithds);

            PdfPCell name = new PdfPCell(new Paragraph("name",tableHeader));
            name.setBorderColor(BaseColor.BLACK);
            name.setPaddingLeft(10);
            name.setHorizontalAlignment(Element.ALIGN_CENTER);
            name.setVerticalAlignment(Element.ALIGN_CENTER);
            name.setBackgroundColor(BaseColor.GRAY);
            name.setExtraParagraphSpace(5f);
            table.addCell(name);

            PdfPCell surname = new PdfPCell(new Paragraph("surname",tableHeader));
            surname.setBorderColor(BaseColor.BLACK);
            surname.setPaddingLeft(10);
            surname.setHorizontalAlignment(Element.ALIGN_CENTER);
            surname.setVerticalAlignment(Element.ALIGN_CENTER);
            surname.setBackgroundColor(BaseColor.GRAY);
            surname.setExtraParagraphSpace(5f);
            table.addCell(surname);

            PdfPCell amount = new PdfPCell(new Paragraph("amount",tableHeader));
            amount.setBorderColor(BaseColor.BLACK);
            amount.setPaddingLeft(10);
            amount.setHorizontalAlignment(Element.ALIGN_CENTER);
            amount.setVerticalAlignment(Element.ALIGN_CENTER);
            amount.setBackgroundColor(BaseColor.GRAY);
            amount.setExtraParagraphSpace(5f);
            table.addCell(amount);

            PdfPCell currency = new PdfPCell(new Paragraph("currency",tableHeader));
            currency.setBorderColor(BaseColor.BLACK);
            currency.setPaddingLeft(10);
            currency.setHorizontalAlignment(Element.ALIGN_CENTER);
            currency.setVerticalAlignment(Element.ALIGN_CENTER);
            currency.setBackgroundColor(BaseColor.GRAY);
            currency.setExtraParagraphSpace(5f);
            table.addCell(currency);

            for(Donation donation : donationList){



                PdfPCell nameValue = new PdfPCell(new Paragraph(donation.getName(),tableBody));
                nameValue.setBorderColor(BaseColor.BLACK);
                nameValue.setPaddingLeft(10);
                nameValue.setHorizontalAlignment(Element.ALIGN_CENTER);
                nameValue.setVerticalAlignment(Element.ALIGN_CENTER);
                nameValue.setBackgroundColor(BaseColor.WHITE);
                nameValue.setExtraParagraphSpace(5f);
                table.addCell(nameValue);

                PdfPCell surnameValue = new PdfPCell(new Paragraph(donation.getSurname(),tableBody));
                surnameValue.setBorderColor(BaseColor.BLACK);
                surnameValue.setPaddingLeft(10);
                surnameValue.setHorizontalAlignment(Element.ALIGN_CENTER);
                surnameValue.setVerticalAlignment(Element.ALIGN_CENTER);
                surnameValue.setBackgroundColor(BaseColor.WHITE);
                surnameValue.setExtraParagraphSpace(5f);
                table.addCell(surnameValue);

                PdfPCell amountValue = new PdfPCell(new Paragraph(Double.toString(donation.getAmount()),tableBody));
                amountValue.setBorderColor(BaseColor.BLACK);
                amountValue.setPaddingLeft(10);
                amountValue.setHorizontalAlignment(Element.ALIGN_CENTER);
                amountValue.setVerticalAlignment(Element.ALIGN_CENTER);
                amountValue.setBackgroundColor(BaseColor.WHITE);
                amountValue.setExtraParagraphSpace(5f);
                table.addCell(amountValue);

                PdfPCell currencyValue = new PdfPCell(new Paragraph(donation.getCurrency(),tableBody));
                currencyValue.setBorderColor(BaseColor.BLACK);
                currencyValue.setPaddingLeft(10);
                currencyValue.setHorizontalAlignment(Element.ALIGN_CENTER);
                currencyValue.setVerticalAlignment(Element.ALIGN_CENTER);
                currencyValue.setBackgroundColor(BaseColor.WHITE);
                currencyValue.setExtraParagraphSpace(5f);
                table.addCell(currencyValue);


        }
            document.add(table);
            document.close();
            writer.close();
            return true;

        }catch(Exception e){

            return false;
        }
    }
}

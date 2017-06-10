import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Header;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFgen {
	public static void createpdf(List<String> a,int column,String path,String filename,String Heading)
	{
		Document document = new Document();
		try
	    {
		String file=path.concat(filename);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
        Chunk sigUnderline = new Chunk(Heading);
        sigUnderline.setUnderline(0.1f, -2f);
        sigUnderline.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12,Font.BOLD|Font.UNDERLINE));
        
        Paragraph para = new Paragraph();
        para.add(sigUnderline);
        para.setAlignment(Element.ALIGN_CENTER);
        document.add(para);
        document.add(Chunk.NEWLINE);
 
        PdfPTable table = new PdfPTable(column); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        PdfPCell cell = new PdfPCell(new Paragraph("S.No."));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderColor(BaseColor.BLACK);
        cell.setPaddingLeft(10);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        for(int i=1;i<column;i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell1);
        }
        for(int i=column;i<a.size();i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.WHITE);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell1);
        }
 
        document.add(table);
 
        document.close();
        writer.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
	
	};
	public static void createNBAReport(List<String> a,int[] column,String path,String filename,String Heading)
	{
		Document document = new Document();
		try
	    {
		String file=path.concat(filename);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
        Chunk title = new Chunk(Heading);
        title.setUnderline(0.1f, -2f);
        title.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12,Font.BOLD|Font.UNDERLINE));
        
        Paragraph para = new Paragraph();
        para.add(title);
        para.setAlignment(Element.ALIGN_CENTER);
        document.add(para);
        document.add(Chunk.NEWLINE);
        
        Chunk title1 = new Chunk("BE");
        title1.setUnderline(0.1f, -2f);
        title1.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12,Font.BOLD|Font.UNDERLINE));
        
        Paragraph para1 = new Paragraph();
        para1.add(title1);
        para1.setAlignment(Element.ALIGN_CENTER);
        document.add(para1);
        document.add(Chunk.NEWLINE);
 
        PdfPTable table = new PdfPTable(3); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        PdfPCell cell = new PdfPCell(new Paragraph("S.No."));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderColor(BaseColor.BLACK);
        cell.setPaddingLeft(10);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        for(int i=1;i<3;i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell1);
        }
        for(int i=3;i<column[0];i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.WHITE);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell1);
        }
        document.add(table);
        
        document.add(Chunk.NEWLINE);
        
        Chunk title2 = new Chunk("TE");
        title2.setUnderline(0.1f, -2f);
        title2.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12,Font.BOLD|Font.UNDERLINE));
        
        Paragraph para2 = new Paragraph();
        para2.add(title2);
        para2.setAlignment(Element.ALIGN_CENTER);
        document.add(para2);
        document.add(Chunk.NEWLINE);
 
        PdfPTable table1 = new PdfPTable(3); // 3 columns.
        table1.setWidthPercentage(100); //Width 100%
        table1.addCell(cell);
        for(int i=1;i<3;i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table1.addCell(cell1);
        }
        for(int i=column[0];i<column[1];i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.WHITE);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table1.addCell(cell1);
        }
 
        document.add(table1);
        document.add(Chunk.NEWLINE);
        
        Chunk title3 = new Chunk("SE");
        title3.setUnderline(0.1f, -2f);
        title3.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12,Font.BOLD|Font.UNDERLINE));
        
        Paragraph para3 = new Paragraph();
        para3.add(title3);
        para3.setAlignment(Element.ALIGN_CENTER);
        document.add(para3);
        document.add(Chunk.NEWLINE);
 
        PdfPTable table2 = new PdfPTable(3); // 3 columns.
        table2.setWidthPercentage(100); //Width 100%
        table2.addCell(cell);
        for(int i=1;i<3;i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table2.addCell(cell1);
        }
        for(int i=column[1];i<column[2];i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.WHITE);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table2.addCell(cell1);
        }
 
        document.add(table2);
 
        document.close();
        writer.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
	
	};
	public static void createyellowcard(String Ano,String Cno,String title,String Author,List<String> a,int column,String path,String filename,String Heading)
	{
		Document document = new Document();
		try
	    {
		String file=path.concat(filename);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
        Chunk sigUnderline = new Chunk(Heading);
        sigUnderline.setUnderline(0.1f, -2f);
        sigUnderline.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12,Font.BOLD|Font.UNDERLINE));
        
        Paragraph para = new Paragraph();
        para.add(sigUnderline);
        para.setAlignment(Element.ALIGN_CENTER);
        document.add(para);
        document.add(Chunk.NEWLINE);
        
        Chunk sigUnderline1 = new Chunk("A.NO. :"+Ano);
        sigUnderline1.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12));
        
        Paragraph para1 = new Paragraph();
        para1.add(sigUnderline1);
        para1.setAlignment(Element.ALIGN_LEFT);
        document.add(para1);
        document.add(Chunk.NEWLINE);
        Chunk sigUnderline12 = new Chunk("C.NO. :"+Cno);
        sigUnderline12.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12));
        
        Paragraph para12 = new Paragraph();
        para12.add(sigUnderline12);
        para12.setAlignment(Element.ALIGN_LEFT);
        document.add(para12);
        document.add(Chunk.NEWLINE);
        
        Chunk sigUnderline3 = new Chunk("Title :"+title);
        sigUnderline3.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12));
        
        Paragraph para3 = new Paragraph();
        para3.add(sigUnderline3);
        para3.setAlignment(Element.ALIGN_LEFT);
        document.add(para3);
        document.add(Chunk.NEWLINE);
        Chunk sigUnderline4 = new Chunk("Author :"+Author);
        sigUnderline4.setFont(new Font(Font.getFamily("TIMES_ROMAN"), 12));
        
        Paragraph para4 = new Paragraph();
        para4.add(sigUnderline4);
        para4.setAlignment(Element.ALIGN_LEFT);
        document.add(para4);
        document.add(Chunk.NEWLINE);
 
        PdfPTable table = new PdfPTable(column); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        PdfPCell cell = new PdfPCell(new Paragraph("S.No."));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderColor(BaseColor.BLACK);
        cell.setPaddingLeft(10);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        for(int i=1;i<column;i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell1);
        }
        for(int i=column;i<a.size();i++)
        {
        PdfPCell cell1 = new PdfPCell(new Paragraph(a.get(i)));
        cell1.setBackgroundColor(BaseColor.WHITE);
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell1);
        }
 
        document.add(table);
 
        document.close();
        writer.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
	
	};
	public static void printJtable(String path) {
	    Document document = new Document(PageSize.A4.rotate());
	    try {
	      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path+"jTable.pdf"));
	      document.open();
	      PdfPTable pdfTable = new PdfPTable(Gui3.table_1.getColumnCount());
	      for (int i = 0; i < Gui3.table_1.getColumnCount(); i++) {
              pdfTable.addCell(Gui3.table_1.getColumnName(i));
          }
          //extracting data from the JTable and inserting it to PdfPTable
          for (int rows = 0; rows < Gui3.table_1.getRowCount() - 1; rows++) {
              for (int cols = 0; cols < Gui3.table_1.getColumnCount(); cols++) {
                  pdfTable.addCell(Gui3.table_1.getModel().getValueAt(rows, cols).toString());
              }
          }
          document.add(pdfTable);
          document.close();
          writer.close();
	    } catch (Exception e) {
	      System.err.println(e.getMessage());
	    }
	    document.close();
	  }
     
}

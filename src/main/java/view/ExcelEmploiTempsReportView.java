package view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import dao.EmploiTempsRepository;
import dao.FiliereRepository;


public class ExcelEmploiTempsReportView extends AbstractExcelView 
{
	@Autowired
	FiliereRepository filiereRepository;
	
	@Autowired
	EmploiTempsRepository emploiTempsRepository;

	@Override
 	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
   HttpServletResponse response) throws Exception 
   		{
	 		response.setHeader("Content-disposition", "attachment; filename=\"user_list.xls\"");
	 		
	 		@SuppressWarnings("unchecked")
	 		List<TestClass> listclasse = (List<TestClass>) model.get("listClasse");
	 		
	 		HSSFCellStyle style = workbook.createCellStyle();
	        style.setFillForegroundColor(HSSFColor.LIME.index);
	        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	 		
	        
	 		Sheet sheet = workbook.createSheet("Salle List");
	 		
	 		 HSSFCellStyle headerStyle = workbook.createCellStyle();
	         HSSFFont headerFont = workbook.createFont();
	         headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	         headerStyle.setFont(headerFont); 
	         
	         sheet.setDefaultColumnWidth((short) 12);
	         /*
	 		for(int i=0; i<10; i++)
	 		{
	 			sheet.autoSizeColumn(i);
	 			sheet.setColumnWidth(i, 8*256);
	 		}*/
	 		
	 		Row header = sheet.createRow(0);
	 		header.createCell(0).setCellValue("8h-10h");
	 		header.createCell(1).setCellValue("10h-12h");
	 		header.createCell(2).setCellValue("14h-16h");
	 		header.createCell(3).setCellValue("16h-18h");
  
	 		int rowNum = 1;
	 		
	 		for(TestClass test : listclasse)
	 		{
	 			Row row = sheet.createRow(rowNum++);
	 			row.createCell(0).setCellValue(test.getParaOne());
	 			row.createCell(1).setCellValue(test.getParaTwo());
	 			row.createCell(2).setCellValue(test.getParaThree());
	 			row.createCell(3).setCellValue(test.getParaFour());
	 		}	

 }



}
package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilityfile {
         public static void writelanguagedata(List<String> list) throws IOException
         {
        	
           	 String path="C:\\Users\\2304014\\eclipse-workspace\\IdentifyCourses\\data\\LanguageLearningdata.xlsx";
        	 FileOutputStream file=new FileOutputStream(path);
        	 XSSFWorkbook workbook=new XSSFWorkbook();
        	 XSSFSheet sheet1=workbook.createSheet("Language");
        	 for(int i=0;i<list.size();i++)
        	 {
        		 XSSFRow row=sheet1.createRow(i);
        		 row.createCell(0).setCellValue(list.get(i));
        	 }
        	 workbook.write(file);
        	 workbook.close();
        	 file.close();
        	 
         }
         public static void writeleveldata(List<String> list) throws IOException
         {
           	 String path="C:\\Users\\2304014\\eclipse-workspace\\IdentifyCourses\\data\\LanguageLearning_difflevel_data.xlsx";
        	 FileOutputStream file=new FileOutputStream(path);
        	 XSSFWorkbook workbook=new XSSFWorkbook();
        	 XSSFSheet sheet=workbook.createSheet("DifferentLevel");
        	 for(int i=0;i<list.size();i++)
        	 {
        		 XSSFRow row=sheet.createRow(i);
        		 row.createCell(0).setCellValue(list.get(i));
        	 }
        	 workbook.write(file);
        	 workbook.close();
        	 file.close();
        	 
         }
         public static String[] readExcelData(String Sheet1) throws IOException{ 
         	String path = "C:\\Users\\2304014\\eclipse-workspace\\IdentifyCourses\\TestData\\testdata.xlsx";
             FileInputStream file = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(file);
             XSSFSheet sheet = workbook.getSheet("Sheet1");        
             int row =sheet.getPhysicalNumberOfRows();
            
             //int c_no = row.getLastCellNum();
             String Data[] = new String[row];
             for(int i=0; i<row; i++)
             { 	
            	 XSSFRow r = sheet.getRow(i);
                 Data[i] = String.valueOf(r.getCell(0));
             }
             workbook.close();
             return Data;
}
}
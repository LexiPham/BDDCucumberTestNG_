package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	public final static String Path_Template = Paths.get(System.getProperty("user.dir") + "/src/main/resources/TestDataTemplate/TestData.xlsx").toString();
	public final static String Path_Result = Paths.get(System.getProperty("user.dir") + "/src/main/resources/TestDataResult/TestData.xlsx").toString();	

	public ExcelUtils() throws IOException {
        Path source= Paths.get(System.getProperty("user.dir") + "/src/main/resources/TestDataTemplate/TestData.xlsx");
        Path target = Paths.get(System.getProperty("user.dir") + "/src/main/resources/TestDataResult/TestData.xlsx");
        
        Files.delete(target);   	
        Files.copy(source, target);
	}
	
	public static void openExcelUtils(String sheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path_Result);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}
	}
	public static void saveExcelUtils() throws Exception {
		try {
			FileOutputStream fileOut = new FileOutputStream(Path_Result);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static void setCellData(String sheetname, String Result, int RowNum, int ColNum) throws Exception {
		openExcelUtils(sheetname);
		try {
			Row = ExcelWSheet.createRow(RowNum - 1);
			Cell = Row.createCell(ColNum - 1);
			Cell.setCellValue(Result);
		} catch (Exception e) {
			throw (e);
		}
		saveExcelUtils();
	}
}

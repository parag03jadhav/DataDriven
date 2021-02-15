package com.pj.DataProvider.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pj.po.Register;

public class AppTest 
   
{
	
	public static WebDriver driver;
	public static  PageFactory po;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;
	
	
	@BeforeTest
	public void ExcelOpration() throws IOException {
		
		FileInputStream fi=new FileInputStream("C:\\java\\eclipes\\selenium\\DataProvider\\src\\test\\java\\resource\\TestData.xlsx");
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet("Sheet1");
	}
	
	
	@Test
	(dataProvider="Data")
	public void OpenBrowser(String userN,String userL,String mail,String e3,String pass1,String pass2,String mob,String d,String m,String y) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parag\\Downloads\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.takealot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Register reg=PageFactory.initElements(driver, Register.class);
		 Thread.sleep(5000);
		// reg.RegAction(userN, userL, mail, e3, pass1, pass2, mob, d, m, y);
	    reg.RegAction(userN, userL, mail, e3, pass1, pass2, mob, d, m, y);
	}
	

	@DataProvider
	public Object[][] Data(){
		int RowCount=sh.getLastRowNum();
		row=sh.getRow(0);
		int CellCount=row.getLastCellNum();
		 Object [][] obj=new Object[RowCount][CellCount];
		
		 for (int i = 0; i < RowCount; i++) {
			for (int j = 0; j < CellCount; j++) {
				DataFormatter df = new DataFormatter();
				obj[i][j] = df.formatCellValue(sh.getRow(i + 1).getCell(j));

			}
		}
		return obj;
		
		/*Used For internal Data passing to method
		 * Object [][] obj=new Object[2][10]; obj[0][0]="parag"; obj[0][1]="jadhav";
		 * obj[0][2]="parag12@gmail.com"; obj[0][3]="parag12@gmail.com";
		 * obj[0][4]="parag123"; obj[0][5]="parag123"; obj[0][6]="9763884900";
		 * obj[0][7]="12"; obj[0][8]="February"; obj[0][9]="1997";
		 * 
		 * 
		 * 
		 * 
		 * return obj;
		 */	
		
		
	}


	
	

	
    }

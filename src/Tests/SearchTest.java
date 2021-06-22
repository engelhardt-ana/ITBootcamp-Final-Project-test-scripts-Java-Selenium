package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BasicTest {

	@Test(priority = 0)
	public void searchTest() throws InterruptedException, IOException {
		SoftAssert sa = new SoftAssert();

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");

		this.driver.navigate().to(this.baseUrl + "meals");
		this.locationPopupPage.setLocation("City Center - Albany");
		Thread.sleep(3000);

		for (int i = 1; i <= 3; i++) {
			XSSFRow row = sheet.getRow(i);

			String location = row.getCell(0).getStringCellValue();
			String searchUrl = row.getCell(1).getStringCellValue();
			int result = (int) row.getCell(2).getNumericCellValue();

			this.driver.navigate().to(searchUrl);
			Thread.sleep(3000);
			this.locationPopupPage.getDialogue();
			this.locationPopupPage.setLocation(location);

			Thread.sleep(3000);
			sa.assertEquals(this.searchResultPage.getNumResults(), result,
					"[ERROR]: Number of results don`t match with data.xslx file");

			wb.close();
			fis.close();
			this.sa.assertAll();
		}
	}
}

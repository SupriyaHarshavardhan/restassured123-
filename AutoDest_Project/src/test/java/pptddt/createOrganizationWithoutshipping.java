package pptddt;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class createOrganizationWithoutshipping extends BaseClass
{

		@Test(groups = "smokeTest")
		public void createsorgwithoutshipping() throws Throwable {

			String orgName = eUtil.getExcelData("Sheet1", 1, 2) + "_" + Jutil.getRandomData();
		
			// navigate to organization
			driver.findElement(By.linkText("Organizations")).click();

			// create organization without shipping adress
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName + Jutil.getRandomData());

			
	        //click on save button
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			//verification
			String expdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			Assert.assertTrue(expdata.contains(orgName));

}
}
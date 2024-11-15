package Orgnization;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CreatingNewOrganization;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;
import io.opentelemetry.sdk.metrics.data.Data;

public class CreateoOganizationTest extends BaseClass
{	
	@Test
	public void CreateOrgnizationTest() throws IOException, InterruptedException
	{
		
		Thread.sleep(5000);
		ExcelFileUtility eUtil= new ExcelFileUtility();
		JavaUtility jUtil= new JavaUtility();
		
		String OrgName = eUtil.getDataFromExcel("Organization", 1, 0);
		XSSFCell PhoneNumber = eUtil.getDataFromExcel1("Organization", 1, 1);
		//int Phone = Integer.parseInt(PhoneNumber);
		
		DataFormatter format = new DataFormatter();
		String phone = format.formatCellValue(PhoneNumber);
		
		String Email = eUtil.getDataFromExcel("Organization", 1, 2);
		System.out.println(OrgName);
		
		
		int randomNumber = jUtil.getRandomNumber();
		OrgName=OrgName+randomNumber;
		System.out.println(OrgName);
		
		//step1 Click on Organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		
		//Step2 Click on create organization icon
		OrganizationPage OP= new OrganizationPage(driver);
		OP.clickOnOrganizationImage();
		
		//Step3 Enter all required field to create organization
		CreatingNewOrganization CNO= new CreatingNewOrganization(driver);
		CNO.CreateOrganization(OrgName, Email,phone);
		
		Thread.sleep(2000);
		//Step4 Validate Organization is created 
		OrganizationInfoPage OIP= new OrganizationInfoPage(driver);
		String actualOrganizationHeader = OIP.OrganizationgHeader();
		
		Assert.assertTrue(actualOrganizationHeader.contains(OrgName));
		System.out.println("Done");
	}
}







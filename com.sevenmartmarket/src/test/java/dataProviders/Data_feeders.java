package dataProviders;

import org.testng.annotations.DataProvider;

import com.sevenmartmarket.utility.ExcelReader;

public class Data_feeders {
	ExcelReader excelreader = new ExcelReader();
	
	@DataProvider(name = "UserCredentials")
		public Object[][] adminUserData() {
			return new Object[][] { { "Bala122", "admin","Staff" },{ "devi125", "admin","Partner" } };
		}
	
	@DataProvider(name = "ExcelUserCredentials")
	public Object[][] adminUserDatafromExcel()
	{
		excelreader.setExcelFile("User", "User");
		return excelreader.getMultidimentionalData(2, 3);
	}
		}



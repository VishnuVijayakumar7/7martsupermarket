package dataproviders;

import org.testng.annotations.DataProvider;

import utilities.ExcelReader;

public class DataProviders {
		ExcelReader excelreader = new ExcelReader();

		@DataProvider(name = "userData")
		public Object[][] getLoginData() {
			excelreader.setExcelFile("UserDataProvider");
			return excelreader.getMultidimentionalData(3, 3);
		}
	}


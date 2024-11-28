package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String file=System.getProperty("User.dir"+"//testData//UserData.xlsx");
		XLUtility xl=new XLUtility(file);
		
		
		int rownum= xl.getRowCount("Sheet1");
		int colnum = xl.getCellCount("Sheet1", rownum);
		
		String apiData[][]=new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				apiData[i-1][j]=xl.getCellData("Sheet1", i, j);
				
			}
		}
		return apiData;
	}
	
	@DataProvider(name="Usernames")
	public String[] getUsernames() throws IOException
	{
		String file=System.getProperty("User.dir"+"//testData//UserData.xlsx");
		XLUtility xl=new XLUtility(file);
		
		
		int rownum= xl.getRowCount("Sheet1");
		//int colnum = xl.getCellCount("Sheet1", rownum);
		
		String[] apiData=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
			
				apiData[i-1]=xl.getCellData("Sheet1", i, 1);
		}
		return apiData;
	}
}

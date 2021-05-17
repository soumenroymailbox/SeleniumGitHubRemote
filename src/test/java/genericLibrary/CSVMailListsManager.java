package genericLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import com.csvreader.CsvReader;

import commonLibrary.SystemConfiguration;

public class CSVMailListsManager extends SystemConfiguration
{
	static String filePath = applicationFileDir+"ToMailList.csv";
	public static CsvReader csvReader;
	static ArrayList<String> nameList = new ArrayList<String>();
	static ArrayList<String> emailList = new ArrayList<String>();
	static ArrayList<String> strArrayList = new ArrayList<String>();

	public static int columnCount(String csvFilepath)
	{
		int numberOfHeaders = 0;
		try 
		{
			csvReader = new CsvReader(csvFilepath);
			csvReader.readHeaders();
			numberOfHeaders = csvReader.getHeaderCount();
		}
		catch (Exception e) 
		{
			System.out.println("Error Occurs in Column Counting"+e.getMessage());
		}
		return numberOfHeaders;
	}

	public static int rowCountExceptHeading()
	{
		BufferedReader reader = null;
		int lines = 0;
		try 
		{
			reader = new BufferedReader(new FileReader(filePath));
			while (reader.readLine() != null)
			{
				lines++;
			}
			reader.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Error Occurs in Row Counting"+e.getMessage());
		}
		return (lines-1);
	}

	@SuppressWarnings("unused")
	public static String [] readLists(String columnName)
	{

		int colNum = columnCount(filePath);
		int rowNum = columnCount(filePath);
		try 
		{
			while (csvReader.readRecord())
			{
				strArrayList.add(csvReader.get(columnName));
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}	

		//To Print The String Array List
		/*
		for (int i = 0; i<rowCountExceptHeading();i++)
		{
			System.out.println(strArrayList.get(i).toString());
		}
		 */
		String[] csvLists = new String[strArrayList.size()];
		strArrayList.toArray(csvLists);

		//To Print The String Array 

		for(String str : csvLists)
		{
			System.out.println(str);
		}

		return csvLists;
	}

	public void printCSVFileContent()  
	{
		int colNum = columnCount(filePath);
		System.out.println("Number of Columns Present Is :\t"+colNum);

		int rowNum = columnCount(filePath);
		System.out.println("Number of Rows Present Is :\t"+rowNum);

		//Header Printing
		for(int i=0;i<colNum;i++)
		{
			try 
			{
				System.out.print(csvReader.getHeader(i)+"\t\t\t");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println();

		try 
		{
			while (csvReader.readRecord())
			{
				nameList.add(csvReader.get("Name"));
				emailList.add(csvReader.get("EMail"));
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}	

		System.out.println("Automation Report has been sent to the below listed peoples:");
		for (int i = 0; i<rowCountExceptHeading();i++)
		{
			System.out.println(nameList.get(i).toString()+"\t\t"+emailList.get(i).toString());
		}
		//			csvReader.close();
	} 

}

package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseManager 
{
	public static String jdbcConnectionServer_Port_Database = "jdbc:sqlserver://vault-qa.ca1rz32nighj.us-east-1.rds.amazonaws.com:1433;database=hmvault-qa";
	public static String dbURLQA = "jdbc:sqlserver://vault-qa.ca1rz32nighj.us-east-1.rds.amazonaws.com:1433;database=hmvault-qa";
	public static String dbUserName = "hmvadmin";
	public static String dbPassWord = "SuperHamburger2000!";
	public static Connection conn = null;
	public static Statement stat = null;
	public static ResultSet result = null;
	public static ResultSetMetaData rsmd = null;
	public static String sqlStr = null;
	public static ArrayList<String> resultArrayList = null;

	public static ResultSet connection(String dbEnvironment,String dbQuery) throws Throwable
	{
		if(dbEnvironment.equalsIgnoreCase("QA"))
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(jdbcConnectionServer_Port_Database,dbUserName,dbPassWord);
			if(conn!=null)
			{
				System.out.println("Connected to the database");
			}
			else 
			{
				System.out.println("Failed to connect to "+dbEnvironment+" database");
			}
			stat = conn.createStatement();
			result = stat.executeQuery(dbQuery);
		}
		else
		{
			System.out.println("This Environment Is Not Ready Yet !");
		}

		return result;
	}


	public static void getQueryResultWithColumnNames(String env,String sqlQuery) 
	{
		try 
		{
			ResultSet rs = DataBaseManager.connection(env,sqlQuery);
			rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();	
			while (rs.next())
			{
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i = 1; i < columnsNumber; i++)
				{
					System.out.printf("%-40s|", rsmd.getColumnName(i)+"|");
				}
				System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println();
				for(int j = 1; j < columnsNumber; j++)
				{
					System.out.printf("%-40s",rs.getString(j));
				}
				System.out.println();
			}  

		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (conn != null) 
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	} 

	/*

	public static void getQueryResultWithColumnNames(String env,String sqlQuery) 
	{
		try 
		{
			ResultSet rs = DataBaseManager.connection(env,sqlQuery);
			rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();	
			StringBuilder stringBuilder = new StringBuilder();
			while (rs.next())
			{
				for(int i = 1; i < columnsNumber; i++)
				{
					stringBuilder.append(rsmd.getColumnName(i).trim()+" ");
					if (i > 1) System.out.printf(",    \t");
					System.out.printf(rsmd.getColumnName(i));
				}
//				String reqValue = stringBuilder.substring(0, stringBuilder.length()-1);
//                resultValue.add(reqValue);
				System.out.println();
				for(int j = 1; j < columnsNumber; j++)
				{
					stringBuilder.append(rs.getString(j).trim()+" ");
					System.out.printf("%s",rs.getString(j) + ",\t");
//					System.out.printf(rsmd.getColumnName(i));
				}
				System.out.println();
			}  

		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (conn != null) 
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	} 

	 */


//	public static int getRowCount(ResultSet set) throws SQLException
//	{
//	   int rowCount;
//	   int currentRow = set.getRow();            // Get current row
//	   rowCount = set.last() ? set.getRow() : 0; // Determine number of rows
//	   if (currentRow == 0)                      // If there was no current row
//	      set.beforeFirst();                     // We want next() to go to first row
//	   else                                      // If there WAS a current row
//	      set.absolute(currentRow);              // Restore it
//	   return rowCount;
//	}
	

	public static ResultSet getSingleColumnResult(String dbQuery) throws SQLException
	{
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(jdbcConnectionServer_Port_Database,dbUserName,dbPassWord);
			stat = conn.createStatement();
			sqlStr = dbQuery;
			result = stat.executeQuery(sqlStr);
			while (result.next())
			{
				System.out.println(result.getString("id"));
				System.out.println(result.getString("name"));
			}    

		} 
		catch (Exception e) 
		{
			System.out.println("Exception Occurs "+e.getMessage());
		} 

		return result;
	}

	public static ResultSet getMultipleColumnResult(String dbQuery) throws SQLException
	{
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(jdbcConnectionServer_Port_Database,dbUserName,dbPassWord);
			stat = conn.createStatement();
			sqlStr = dbQuery;
			result = stat.executeQuery(sqlStr);
			rsmd = result.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (result.next())
			{
				for(int i = 1; i < columnsNumber; i++)
				{
					if (i > 1) System.out.print(",\t");
					System.out.printf(rsmd.getColumnName(i));
				}
				System.out.println();
				for(int j = 1; j < columnsNumber; j++)
				{
					System.out.printf(result.getString(j) + ",\t");
				}
				System.out.println();
			}    

		} 
		catch (Exception e) 
		{
			System.out.println("Exception Occurs "+e.getMessage());
		} 

		return result;
	}

	public static ArrayList<String> db(String dbQuery) throws Throwable 
	{
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(jdbcConnectionServer_Port_Database,dbUserName,dbPassWord);
			stat = conn.createStatement();
			sqlStr = dbQuery;
			result = stat.executeQuery(sqlStr);
			rsmd = result.getMetaData();
			
			
			

			int columnsCount = rsmd.getColumnCount();

			
			ArrayList<String> values = new ArrayList<>();
			while (result.next()) 
			{
				
				System.out.print("Columns Names are :- [");
				for(int i = 1; i < columnsCount; i++)
				{
					System.out.printf("%s", rsmd.getColumnName(i)+"  ");
				}
				System.out.print("]\n");
				
				for (int row = 1; row <= 1; row++)
				{
					for (int cell = 1; cell < columnsCount; cell++) 
					{
						values.add(result.getString(cell));
					}
					System.out.println("["+ 1 +"] Row Data is   :- " +values.toString());
				}
				
			}
			return values;

			
			
		} 
		catch (Throwable e)
		{
			throw e;
		}
		finally 
		{
			if (conn != null) 
			{
				conn.close();
			}	
			
		}
	}








	
	public static void rowCount(String dbQuery) throws Exception
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(jdbcConnectionServer_Port_Database,dbUserName,dbPassWord);
		stat = conn.createStatement();
		sqlStr = dbQuery;
		result = stat.executeQuery(sqlStr);
		rsmd = result.getMetaData();
		int rowCount = 0;
		while (result.next()) 
		{
			result.last();
			rowCount = result.getRow();
			rowCount++;
		}
//		result.last();                         
//		int counter = result.getRow();
		System.out.println("Number of records in ResultSet: " + rowCount);
		
		
//		return rowCount;
		
	}
	

}

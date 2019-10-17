package dao.impl;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import oracle.ConnectionPoolOracle;


public class QueryAkaExcelfromPool 
{
	
	

	public  List<ArrayList<String>> queryFIOD(String queryInDB) throws Exception
	{
		List<ArrayList<String>> listRow = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> listCell= null;
	    ResultSet rs = null;
	    Connection conn = null;
        PreparedStatement stmt = null;
			     

		DataSource dataSource = ConnectionPoolOracle.getConnectionDataSource();
	    ConnectionPoolOracle.printStatus();

			        try
			        {
			            conn = dataSource.getConnection();
			            ConnectionPoolOracle.printStatus();

			            stmt = conn.prepareStatement(queryInDB);
			            rs = stmt.executeQuery();
			            while (rs.next())
			            {
			            	listCell = new ArrayList<String>();

							listCell.add(rs.getString(1));
							listCell.add(rs.getString(2));
							listCell.add(rs.getString(3));
							try
							{
								listCell.add(getparsedDate(rs.getString(4)));
							} catch (Exception e) 
							{
								e.printStackTrace();
							}

							listCell.add(rs.getString(5));
							
							listRow.add(listCell);
			            }
			           
			        } finally {
			            if (stmt != null) {
			                stmt.close();
			            }
			            if (conn != null)
			            {
			                conn.close();
			                System.out.println("������� � ���!");
			            }
			        }
			        ConnectionPoolOracle.printStatus();
				
			    
	     return listRow;
	}
	
	
	public  List<ArrayList<String>> queryOutENP(String queryInDB) throws Exception
	{
		List<ArrayList<String>> listRow = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> listCell= null;
	    ResultSet rs = null;
	     Connection conn = null;
        PreparedStatement stmt = null;
			     

		DataSource dataSource = ConnectionPoolOracle.getConnectionDataSource();
	    ConnectionPoolOracle.printStatus();

			        try
			        {
			            conn = dataSource.getConnection();
			            ConnectionPoolOracle.printStatus();

			            stmt = conn.prepareStatement(queryInDB);
			            rs = stmt.executeQuery();
			            while (rs.next())
			            {
			            	listCell = new ArrayList<String>();

							listCell.add(rs.getString(1));
							listCell.add(rs.getString(2));
						
							listRow.add(listCell);
			            }
			           
			        } finally {
			            if (stmt != null) {
			                stmt.close();
			            }
			            if (conn != null)
			            {
			                conn.close();
			                System.out.println("������� � ���!");
			            }
			        }
			        ConnectionPoolOracle.printStatus();
				
			    
	     return listRow;
	}


	public String queryGenerateEnp(String [] vids){
		String response = "";
		Connection conn = null;
		PreparedStatement stmt = null;

		DataSource dataSource = ConnectionPoolOracle.getConnectionDataSource();
		try{
			conn = dataSource.getConnection();
			for(String id : vids){
				CallableStatement statement = conn.prepareCall("{call p_gen_new_enp(?)}");
				statement.setString(1,id);
				statement.execute();
				response += id + "-generate ok!\n";
			}
		} catch (SQLException e){
			System.out.println(e.getMessage());
			return response + e.getMessage();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
					System.out.println("������� � ���!");
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return response;
	}




	public  List<ArrayList<String>> queryEditOutENP(ArrayList<String> queryInDB) throws Exception
	{
		List<ArrayList<String>> listRow = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> listCell= null;
	    ResultSet rs = null;
	    Connection conn = null;
        PreparedStatement stmt = null;
			     

		DataSource dataSource = ConnectionPoolOracle.getConnectionDataSource();
	    ConnectionPoolOracle.printStatus();

			        try
			        {
			            conn = dataSource.getConnection();
			            ConnectionPoolOracle.printStatus();
			            
			            for (int i = 0; i < queryInDB.size(); i++) {
			            	stmt = conn.prepareStatement(queryInDB.get(i));
				           // stmt.executeQuery();
				            stmt.execute();
				           // stmt.closeOnCompletion();
				       
						}
			            
			            	listCell = new ArrayList<String>();
							listCell.add("������ �������� �������!!!");
							listRow.add(listCell);
							listCell = new ArrayList<String>();
							listCell.add("�������� ����� ������,��� �� ����� ������ ������� ������ ���� ������ �� ������� ���� �� �������.");
							listRow.add(listCell);
							listCell = new ArrayList<String>();
							listCell.add("��������� ��� �� ������ ����� �������������� �������� ������ ��������...� �������� :)");
							listRow.add(listCell);
						
							
			           
			        }
			        
			        finally {
			            if (stmt != null) {
			                stmt.close();
			            }
			            if (conn != null)
			            {
			                conn.close();
			                System.out.println("������� � ���!");
			            }
			        }
			        ConnectionPoolOracle.printStatus();
				
			    
	     return listRow;
	}
	
	
	public  List<ArrayList<String>> queryGenENP(String queryInDB) throws Exception
	{
		List<ArrayList<String>> listRow = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> listCell= null;
	    ResultSet rs = null;
	     Connection conn = null;
        PreparedStatement stmt = null;
			     

		DataSource dataSource = ConnectionPoolOracle.getConnectionDataSource();
	    ConnectionPoolOracle.printStatus();

			        try
			        {
			            conn = dataSource.getConnection();
			            ConnectionPoolOracle.printStatus();

			            stmt = conn.prepareStatement(queryInDB);
			            rs = stmt.executeQuery();
			            while (rs.next())
			            {
			            	listCell = new ArrayList<String>();

							listCell.add(rs.getString(1));
							listCell.add(rs.getString(2));
						
							listRow.add(listCell);
			            }
			           
			        } finally {
			            if (stmt != null) {
			                stmt.close();
			            }
			            if (conn != null)
			            {
			                conn.close();
			                System.out.println("������� � ���!");
			            }
			        }
			        ConnectionPoolOracle.printStatus();
				
			    
	     return listRow;
	}

	
	/*
	 * 
	 * ����� ���������� ���� �� �� 
	 * yyyy-MM-dd HH:mm:ss.SSS  �  dd-mm-yyyy
	 * 
	 */
	 private String getparsedDate(String date) throws Exception 
	 {
	        DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
	        String s1 = date;
	        String s2 = null;
	        Date d;
	        try {
	            d = outputformat.parse(s1);
	            s2 = (new SimpleDateFormat("dd.MM.yyyy")).format(d);

	        } catch (ParseException e) {

	            e.printStackTrace();
	        }

	        return s2;

	  }
	 

}


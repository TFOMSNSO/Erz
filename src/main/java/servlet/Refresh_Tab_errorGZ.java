package servlet;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;

import erznskutil.Report;
import oracle.AppakOracle;
import oracle.ConnectionPoolOracle;

/**
 * Servlet implementation class ActionServlet
 */

@WebServlet("/refresh_tab_errorgz")
public class Refresh_Tab_errorGZ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ResultSet rs = null;
	private   Connection conn = null;
	private  PreparedStatement stmt = null;
	private DataSource dataSource = null;
	private AppakOracle appakTable = new AppakOracle();

    
    public Refresh_Tab_errorGZ() {
        // TODO Auto-generated constructor stub
    }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   List<String> result = new ArrayList<String>();
   
   
   
   try {
		dataSource = ConnectionPoolOracle.getConnectionDataSource();
		conn = dataSource.getConnection();
		ConnectionPoolOracle.printStatus();


		long t1 = System.currentTimeMillis();
		appakTable.goznak_update(stmt,rs,conn);
		long t2 = System.currentTimeMillis();
		System.out.println("goznak_update:" + (t2 - t1)/1000.0);
		appakTable.personAdd_script(stmt,rs,conn);
		long t3 = System.currentTimeMillis();
		System.out.println("personAdd_script:" + (t3 - t2)/1000.0);
		appakTable.refresh_materialize_view(stmt,rs,conn);
		long t4 = System.currentTimeMillis();
		System.out.println("refresh_materialize_view:" + (t4 - t3)/1000.0);
		
		System.out.println("refresh ok");
	} catch (Exception e) {
   		System.out.println("refresh error : " + e.getMessage());
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
	{
	     if (conn != null)
	     {
	         try {conn.close();} catch (SQLException e) {e.printStackTrace(); }
	     }
	}
	ConnectionPoolOracle.printStatus();
	
	new Report().runAll();
   
   
   String json = new Gson().toJson(result);
   System.out.println("refresh_tab_errorgz response:" + json);

   response.setContentType("application/json");
   response.setCharacterEncoding("UTF-8");
   response.getWriter().write(json); 
 }

  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
 }
}

package servlet;

import com.google.gson.Gson;
import oracle.ConnectionPoolOracle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


@WebServlet("/TaskP06")
public class TaskP06 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement stat = null;
        ResultSet res = null;
        Connection conn = null;

        try {
            DataSource dataSource = ConnectionPoolOracle.getConnectionDataSource();
            conn = dataSource.getConnection();
            stat = conn.createStatement();


            res = stat.executeQuery(
                    "select pe.enp from person_enp_output pe \n" +
                            "   where pe.pack_id = 0 and status = 6");

            ArrayList<String> enps = new ArrayList<>();


            int i = 0;
            while(res.next()){
                i++;
                enps.add(res.getString(1));
            }


            ArrayList<ArrayList<String>> result = new ArrayList<>();
            for(String x : enps){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(x);
                result.add(temp);
            }


                System.out.println("count: " +enps.size() + "enps:" + result.toString());
                resp.getWriter().write(new Gson().toJson(result));
//            }








        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) {  try {res.close();} catch (SQLException e) {e.printStackTrace();}  }
            if (stat != null) {  try {stat.close();} catch (SQLException e) {e.printStackTrace();}  }
            if (conn != null) {
                try {conn.close();
                } catch (SQLException e) {e.printStackTrace();}System.out.println("Скинули в пул!");}
        }
    }




}

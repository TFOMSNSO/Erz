package servlet;

import com.google.gson.Gson;
import jdk.nashorn.internal.ir.WhileNode;
import oracle.ConnectionPoolOracle;
import org.hibernate.mapping.Array;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


@WebServlet("/TaskGzNoPolice")
public class TaskGzNoPolice extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateBegin = req.getParameter("dateBegin");
        String dateEnd = req.getParameter("dateEnd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;



        try {
            d1 = dateFormat1.parse(dateBegin);
            d2 = dateFormat1.parse(dateEnd);

            dateBegin = dateFormat.format(d1);
            dateEnd = dateFormat.format(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;

        System.out.println("dateBegin:" + dateBegin + "\ndateEnd:" + dateEnd);
        try{
            DataSource dataSource = ConnectionPoolOracle.getConnectionDataSource();
            conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from goznak_csv g where g.d_insert between ? and ? " +
                    "and enp not in (select n_enp from dawn.t_enp_prod t where t.date_tfoms > d_insert and n_enp = g.enp)");

            preparedStatement.setString(1,dateBegin);
            preparedStatement.setString(2,dateEnd);


            resultSet = preparedStatement.executeQuery();

            ArrayList<ArrayList<String>> data = new ArrayList<>();


            ResultSetMetaData rs = resultSet.getMetaData();
            ArrayList<String> t = new ArrayList<>();
            for (int i = 1; i <= rs.getColumnCount(); i++){
                t.add(rs.getColumnName(i));
            }

            data.add(t);




            while(resultSet.next()){
                ArrayList<String> temp = new ArrayList<>();
                for(int i = 1; i <= 29; i++){
                    temp.add(resultSet.getString(i));
                }
                data.add(temp);
            }


            Map<String, ArrayList<ArrayList<String>>> ind = new LinkedHashMap<String, ArrayList<ArrayList<String>>>();
            ind.put("data1", data );

            String json= new Gson().toJson(ind);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            if (resultSet != null) {  try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}  }
            if (stat != null) {  try {stat.close();} catch (SQLException e) {e.printStackTrace();}  }
            if (conn != null) {
                try {conn.close();
                } catch (SQLException e) {e.printStackTrace();}System.out.println("Скинули в пул!");}
        }

    }
}

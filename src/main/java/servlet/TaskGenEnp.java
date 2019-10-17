package servlet;


import dao.impl.QueryAkaExcelfromPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@WebServlet("/TaskGenEnp")
public class TaskGenEnp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vids = new BufferedReader(new InputStreamReader(req.getInputStream())).readLine();
        vids = vids.substring(1,vids.length()).replaceAll("\"","").replaceAll("]","").replaceAll("\\[","");
        String arr[] = vids.split(",");
        for(String x : arr){
            System.out.print(x + ",");
        }

        QueryAkaExcelfromPool dao = new QueryAkaExcelfromPool();
        String response = dao.queryGenerateEnp(arr);
        resp.getWriter().write(response);
    }
}

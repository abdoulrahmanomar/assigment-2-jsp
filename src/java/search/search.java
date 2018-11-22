package search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class search extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "faculty";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
 
        Statement st;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected!");
            String sid = request.getParameter("sid");
 
            ArrayList al = null;
            ArrayList sid_list = new ArrayList();
            String query = "select * from studen where ID='" + sid + "' ";
           
            System.out.println("query " + query);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String ID = "";
            String sname="";
            String Address = "";
            double Gpa= 0.0;
           
            
            while (rs.next()) {
               
 

                ID =rs.getString(1);
                sname = rs.getString(2);
                Address = rs.getString(3); 
                Gpa = rs.getDouble(4);
            
            
               
            }
           
              
               
            HttpSession session = request.getSession();
            session.setAttribute("ID",ID);
            session.setAttribute("sname",sname);
            session.setAttribute("Adress",Address);
            session.setAttribute("Gpa",Gpa);
            double modGpa =Gpa+0.05;
               
               
                String query2 = "UPDATE studen SET gpa ='"+modGpa+"'WHERE ID ='"+sid+"'";
           System.out.println("query " + query2);
            st = conn.createStatement();
            st.executeUpdate(query2);
               
            
            session.setAttribute("modGpa",modGpa);
             response.sendRedirect("result.jsp");
            
            
            conn.close();
            System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
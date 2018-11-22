<%@ page import="java.util.*" %>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
 
<html>
    <head>
    </head>
    <body>
        <table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>User Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>ID</b></td>
                <td><b>Name</b></td>
                <td><b>address</b></td>
               
                <td><b>Old_Gpa</b></td>
                <td><b>NewGpa</b></td>
            </tr>
           <%
            String sid= request.getSession().getAttribute("ID").toString();
            String sname = request.getSession().getAttribute("sname").toString();
            String Address= request.getSession().getAttribute("Adress").toString();
             String Gpa=request.getSession().getAttribute("Gpa").toString();
             String modGpa= request.getSession().getAttribute("modGpa").toString();
           %>
            
           <tr style="background-color:#00ffff">
                <td><%=sid%></td>
                <td><%=sname%></td>
                <td><%=Address%></td>
                <td><%=Gpa%></td>
                <td><%=modGpa%></td>
                
            </tr>
           
            <tr>
                <td colspan=4 align="center"
                   
            </tr>
            
        </table>
    </body>
</html>
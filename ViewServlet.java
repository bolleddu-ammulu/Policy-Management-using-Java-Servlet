package test;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        
        try {
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/policy", "root", "sanjusanjay");
            PreparedStatement ps=con.prepareStatement("select * from policy");
            ResultSet rs=ps.executeQuery();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Policy Records</title>");
            out.println("<style>");
            out.println("table {");
            out.println("  width: 80%;");
            out.println("  margin: 20px auto;");
            out.println("  border-collapse: collapse;");
            out.println("}");
            out.println("th, td {");
            out.println("  padding: 8px;");
            out.println("  text-align: left;");
            out.println("  border-bottom: 1px solid #ddd;");
            out.println("}");
            out.println("tr:hover {");
            out.println("  background-color: #f5f5f5;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Policy Records</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>ID</th><th>Name</th><th>Amount</th><th>Premium</th></tr>");
            while(rs.next()) {
                out.println("<tr>");
                out.println("<td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<a href =success.jsp>Return to Mainpage</a>");
            out.println("</body>");
            out.println("</html>");
           
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Database error occurred");
        }
    }
}

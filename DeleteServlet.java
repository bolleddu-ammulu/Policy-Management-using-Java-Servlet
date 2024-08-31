package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/policy", "root", "sanjusanjay");
            
            // Retrieving ID parameter from request
            String idStr = request.getParameter("id");
            
            // Check if ID parameter is null or empty
            if (idStr == null || idStr.isEmpty()) {
                response.getWriter().println("Policy ID is missing");
                return;
            }
            
            // Parse ID parameter to appropriate data type
            double id = Double.parseDouble(idStr);
            
            // Prepared statement to delete data from the database
            PreparedStatement ps = con.prepareStatement("DELETE FROM Policy WHERE id = ?");
            ps.setDouble(1, id);
            
            // Execute the query
            int rowsDeleted = ps.executeUpdate();
            
            // Redirect to view page if deletion is successful
            if (rowsDeleted > 0) {
                response.sendRedirect("ViewServlet");
            } else {
                response.getWriter().println("No policy found with the given ID");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error occurred");
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid number format for policy ID");
        }  
    }
}

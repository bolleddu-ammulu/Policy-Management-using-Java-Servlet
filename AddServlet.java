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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/policy","root","sanjusanjay");
            
            // Retrieving parameters from request
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String amountStr = request.getParameter("amount");
            String premiumStr = request.getParameter("premium");
            
            // Check if parameters are null or empty
            if (idStr == null || idStr.isEmpty() || name == null || name.isEmpty() 
                || amountStr == null || amountStr.isEmpty() || premiumStr == null || premiumStr.isEmpty()) {
                response.getWriter().println("Please fill in all fields");
                return;
            }
            
            // Parse parameters to appropriate data types
            double id = Double.parseDouble(idStr);
            double amount = Double.parseDouble(amountStr);
            double premium = Double.parseDouble(premiumStr);
            
            // Prepared statement to insert data into the database
            PreparedStatement ps=con.prepareStatement("insert into Policy (id, name, amount, premium) values (?, ?, ?, ?)");
            ps.setDouble(1, id);
            ps.setString(2, name);
            ps.setDouble(3, amount);
            ps.setDouble(4, premium);
            
            // Execute the query
            int rowsInserted = ps.executeUpdate();
            
            // Redirect to view page if insertion is successful
            if(rowsInserted > 0) {
                response.sendRedirect("ViewServlet");
            } else {
                response.getWriter().println("Failed to add policy");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error occurred");
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid number format for id, amount, or premium");
        }  
    }
}

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Mydatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "p21157";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean isValidUser = checkCredentials(email, password);
        String check = request.getParameter("check");

        if(check != null && check.equals("on")){
            if( (email.equals("sriramakrishnan005@gmail.com") && password.equals("Sriram005")) || (email.equals("srihari6112003@gmail.com") && password.equals("haridevil612")) ){
                response.sendRedirect("admin/admin.html");
            }
        }
        if (isValidUser) {
            HttpSession session = request.getSession();
            session.setAttribute("user",String.valueOf(getUserId(email,password)));
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("Invalid credentials. Please try again.");
        }
    }

    private boolean checkCredentials(String email, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM users WHERE cEmail = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            boolean isValid = resultSet.next();
            resultSet.close();
            pstmt.close();
            conn.close();
            return isValid;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private int getUserId(String email,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM users WHERE cEmail = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            else{
                return -1;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
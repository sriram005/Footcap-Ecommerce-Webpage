import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CompleteServlet")
public class CompleteServlet extends HttpServlet{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Mydatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "p21157";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uid = (String)session.getAttribute("user");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        PrintWriter out = resp.getWriter();
        boolean isSuccess = UpdateOrder(uid, name, email, address, phone);

        if(isSuccess){
            out.println("<h1> your order has been Placed </h1>");
        }
        else{
            out.println("Somthing Went Wrong");
        }
    }

    public Boolean UpdateOrder(String uid, String name, String email, String address,String phone){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "Insert into Order_table (name, email, address, phone, uid) values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, address);
            st.setString(4, phone);
            st.setString(5, uid);
            int result = st.executeUpdate();
            st.close();
            con.close();
            return result>0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}

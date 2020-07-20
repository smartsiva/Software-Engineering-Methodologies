import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("Name");  
String f=request.getParameter("Fathername");  
String m=request.getParameter("MobileNumber");  
String e=request.getParameter("Email");
String a=request.getParameter("Age");
String d=request.getParameter("Address");
String s=request.getParameter("State");

          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","root","");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into registeruser values(?,?,?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,f);  
ps.setString(3,m);  
ps.setString(4,e);  
ps.setString(5,a);  
ps.setString(6,d);
ps.setString(7,s);      
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  
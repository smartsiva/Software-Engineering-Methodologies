import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class Search extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();        
              String name=request.getParameter("uname");                          
              try{
                     Class.forName("oracle.jdbc.driver.OracleDriver");
                     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe","sandeep","welcome");               
                     PreparedStatement ps=con.prepareStatement("select * from userlogin where name=?");
                     ps.setString(1,name);                   
                     out.print("<table width=25% border=1>");
                     out.print("<center><h1>Result:</h1></center>");
                     ResultSet rs=ps.executeQuery();                
                     /* Printing column names */
                     ResultSetMetaData rsmd=rs.getMetaData();
                     while(rs.next())
                        {
                     out.print("<tr>");
                     out.print("<td>"+rsmd.getColumnName(1)+"</td>");
                        out.print("<td>"+rs.getString(1)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                        out.print("<td>"+rs.getString(2)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
                        out.print("<td>"+rs.getString(3)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
                        out.print("<td>"+rs.getString(4)+"</td></tr>");                  
                     }
                     out.print("</table>");
 
              }catch (Exception e2)
                {
                    e2.printStackTrace();
                }
 
              finally{out.close();
                }
       }
}

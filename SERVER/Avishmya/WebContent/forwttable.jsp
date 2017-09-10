<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
try {
	Statement st,stt,sttt;
	ResultSet rs,rss,rsss;
	String q,qq,qqq,kk,id,no;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	 q="select * from avishmyaadmin";
	 st=con.createStatement();
	 rs=st.executeQuery(q);
	out.print("<center><INPUT TYPE=\"button\" onClick=\"history.go(0)\" VALUE=\"Refresh\"></center><br><h2><center>ORDER DETAILS</center></h2><hr><marquee><b>Avishmya Restaurant Waiter System</b></marquee><hr>");
	out.print("<center><table border='1'> <tr><th>Code</th><th>NAME</th><th>SEAT</th><th>STATUS</th><th>ORDER LIST</th></tr>");
	while(rs.next())
	{
		//out.print(rs.getString(1));
		 qq="select * from avishmyaitemorder where code ='"+rs.getString(1)+"'";
		 stt=con.createStatement();
		 rss=stt.executeQuery(qq);
		 kk="<center><table>";
		while(rss.next()){
			//out.print(rss.getString(2));
			 id=rss.getString(2);
			 no=rss.getString(3);
			 qqq="select * from avishmya where menuid ='"+id+"'";
			 sttt=con.createStatement();
			 rsss=sttt.executeQuery(qqq);
			while(rsss.next())
			{
				kk=kk+"<tr><th>"+rsss.getString(2)+" -- "+no+" plate</th></tr>";
			}
		}
		kk=kk+"</table></center>";
		//out.print(kk);
		out.print("<tr><th><center>"+rs.getString(1)+"</center></th><td><center>"+rs.getString(2)+"</center></td><td><center>"+rs.getString(3)+"</center></td><td><center>"+rs.getString(5)+"</center></td><td>"+kk+"</td></tr>");	
	}
	out.print("</table></center>");	
	
}
catch(Exception e){e.printStackTrace();out.print(e);}
%>

</body>
</html>
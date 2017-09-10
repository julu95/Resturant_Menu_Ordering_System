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
String s=request.getParameter("code");
//String s="1";
//String s="sipusoumya8@gmail.com";
try {
	if(s.toString().trim().toCharArray().length!=0){
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select code from avishmyaadmin";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	boolean b=true;
	while(rs.next())
	{
		if(s.equals(rs.getString(1).toString().trim())){
			b=false;
			break;
		}
	}	
	if(b){
		
		String qq="select code from avishmyalogin";
		Statement stt=con.createStatement();
		ResultSet rss=stt.executeQuery(qq);
		boolean bb=true;
		while(rss.next())
		{
			if(s.equals(rss.getString(1).toString().trim())){
				bb=false;
				break;
			}
		}
		if(bb){
		String q1="insert into avishmyalogin values(?) ";
		PreparedStatement pst;
		pst = con.prepareStatement(q1);
		pst.setString(1, s);
		int status=pst.executeUpdate();
			if(status==1){
				out.print("<h3><center>ADD LOGIN CODE</center></h3><hr><marquee><b>Avishmya Restaurant Add Code</b></marquee><hr>");
				out.print("<center><h3>Sucessfully Item inserted</h3><br<br>");
				out.print("<form action='gencode.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
			}
			else{
				out.print("<h3><center>ADD LOGIN CODE</center></h3><hr><marquee><b>Avishmya Restaurant Add Code</b></marquee><hr>");
				out.print("<center><h3>Item not inserted</h3><br<br>");
				out.print("<form action='gencode.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
			}
		}
		else{
			out.print("<h3><center>ADD LOGIN CODE</center></h3><hr><marquee><b>Avishmya Restaurant Add Code</b></marquee><hr>");
			out.print("<center><h3>Code is Already Present</h3><br<br>");
			out.print("<form action='gencode.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
		
		}
	}
	else{
		out.print("<h3><center>ADD LOGIN CODE</center></h3><hr><marquee><b>Avishmya Restaurant Add Code</b></marquee><hr>");
		out.print("<center><h3>Code is Already given to costomer</h3><br<br>");
		out.print("<form action='gencode.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
	
	}
	con.close();
	}
	else{
		out.print("<h3><center>ADD LOGIN CODE</center></h3><hr><marquee><b>Avishmya Restaurant Add Code</b></marquee><hr>");
		out.print("<center><h3>plz fill Code field</h3><br<br>");
		out.print("<form action='gencode.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
	
	}
	
}
catch(Exception e){
	out.print("<h3><center>ADD LOGIN CODE</center></h3><hr><marquee><b>Avishmya Restaurant Add Code</b></marquee><hr>");
out.print("<center><h3>"+e+"</h3><br<br>");
out.print("<form action='gencode.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");

}

%>
</body>
</html>
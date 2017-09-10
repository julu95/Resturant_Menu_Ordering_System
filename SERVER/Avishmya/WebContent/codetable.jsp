<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	String q="select code from avishmyalogin";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	int i=0;
	String kk="<center><table border=\'1\'> <tr><th>Sl no.</th><th>Code</th></tr>";
	out.print("<h3><center>GENERATING LOGIN CODE</center></h3><hr><marquee><b>Avishmya Restaurant Code Generation</b></marquee><hr>");
	while(rs.next()){
		i++;
		kk=kk+"<tr><th>"+i+"</th><th>"+rs.getString(1)+"</th></tr>";
	}
	con.close();
	if(i>0){
	out.print(kk+"</table></center>");
	}
	else{
		out.print("<center><h3>No Codes Are Available</h3><br><br>");
	}
	out.print("<br><br><center><INPUT TYPE=\"button\" onClick=\"history.go(0)\" VALUE=\"Refresh\"></center></center>");
}
catch(Exception e){e.printStackTrace();}

%>
</body>
</html>
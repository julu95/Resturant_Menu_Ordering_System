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
String seat=request.getParameter("seat");
String status=request.getParameter("sts");

//String un="avmanager";
//String psw="manager";

try {
	
	if(seat.trim().toCharArray().length!=0 && status.trim().toCharArray().length!=0){
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	String qq="select count(*) from avishmyaadmin where code='"+seat.trim()+"'";
	Statement stt=con.createStatement();
	ResultSet rss=stt.executeQuery(qq);
	while(rss.next())
	{
		if(rss.getInt(1)==1){
			String q="UPDATE avishmyaadmin SET status = ? where code=?";
			PreparedStatement pst;
			pst = con.prepareStatement(q);
			pst.setString(1, status);
			pst.setString(2, seat);
			int st=pst.executeUpdate();
			if(st==1)
			{out.print("<center><h3>Sucessfully Updated</h3><br><br>");
			out.print("<button onclick=\"goBack()\">Back</button></center>");
			}
			else{
				out.print("<center><h3>Not updated</h3><br><br>");
				out.print("<button onclick=\"goBack()\">Back</button></center>");
			}
		}
	else{
		out.print("<center><h3>plz enter correct code</h3><br><br>");
		out.print("<button onclick=\"goBack()\">Back</button></center>");
	}
	}
	}
	
else{
	out.print("<center><h3>plz fill all field</h3><br><br>");
	out.print("<button onclick=\"goBack()\">Back</button></center>");
}	
	
}
catch(Exception e){out.print("<center><h3>"+e+"</h3><br><br>");
out.print("<button onclick=\"goBack()\">Back</button></center>");}
%>

</body>
</html>
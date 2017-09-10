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
String s=request.getParameter("id");
//String s="1";
//String s="sipusoumya8@gmail.com";
try {
	if(s.toString().trim().toCharArray().length!=0){
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select menuid from avishmya";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	boolean b=false;
	while(rs.next())
	{
		if(s.equals(rs.getString(1).toString().trim())){
			b=true;
			break;
		}
	}	
	if(b){
		String q1="delete from avishmya where menuid=?";
		PreparedStatement pst;
		pst = con.prepareStatement(q1);
		pst.setString(1, s);
		int status=pst.executeUpdate();
		if(status==1){
			out.print("<h3><center>DELETE ITEM FROM MENU</center></h3><hr><marquee><b>Avishmya Restaurant Delete Item</b></marquee><hr>");
			out.print("<center><h3>Sucessfully Item Deleted</h3><br<br>");
			out.print("<form action='menuitemdelete.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
		}
		else{
			out.print("<h3><center>DELETE ITEM FROM MENU</center></h3><hr><marquee><b>Avishmya Restaurant Delete Item</b></marquee><hr>");
			out.print("<center><h3>Item not Deleted</h3><br<br>");
			out.print("<form action='menuitemdelete.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
		}
	}
	else{
		out.print("<h3><center>DELETE ITEM FROM MENU</center></h3><hr><marquee><b>Avishmya Restaurant Delete Item</b></marquee><hr>");
		out.print("<center><h3>Delete id is not found</h3><br<br>");
		out.print("<form action='menuitemdelete.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
	
	}
	con.close();
	}
	else{
		out.print("<h3><center>DELETE ITEM FROM MENU</center></h3><hr><marquee><b>Avishmya Restaurant Delete Item</b></marquee><hr>");
		out.print("<center><h3>plz fill id field</h3><br<br>");
		out.print("<form action='menuitemdelete.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
	
	}
	
}
catch(Exception e){e.printStackTrace();
out.print("<h3><center>DELETE ITEM FROM MENU</center></h3><hr><marquee><b>Avishmya Restaurant Delete Item</b></marquee><hr>");
out.print("<center><h3>"+e+"</h3><br<br>");
out.print("<form action='menuitemdelete.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");

}

%>
</body>
</html>
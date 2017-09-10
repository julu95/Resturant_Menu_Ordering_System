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
String id=request.getParameter("id");
//String s="1";
//String s="sipusoumya8@gmail.com";
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	if(id.trim().toCharArray().length!=0)
	{
		String q="select menuid from avishmya";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(q);
		boolean kk=false;
		while(rs.next())
		{
			if(id.toString().trim().equals(rs.getString(1))){
				kk=true;
				break;
			}
		}
		if(kk){
			
			String qq="select * from avishmya where menuid='"+id+"'";
			Statement stt=con.createStatement();
			ResultSet rss=stt.executeQuery(qq);
			while(rss.next())
			{
				String a="";
				if(rss.getString(4).equals("1")) a="starter";
				else if(rss.getString(4).equals("2")) a="Rice";
				else if(rss.getString(4).equals("3")) a="Non Veg";
				else if(rss.getString(4).equals("4")) a="Veg";
				else  a="Dessert";
				out.print("<form action=\"menuitemedit2.jsp\" method=\"post\"><h5>&nbsp&nbsp&nbspId: <input type=\"text\" value=\""+id+"\" class=\"field left\" name=\"id\" readonly><br><br>Name: <input type=\"text\" name=\"name\" value=\""+rss.getString(2)+"\"></input><br><br>&nbspPrice: <input type=\"number\" name=\"price\"min=\"1\" max=\"1000\" value=\""+rss.getString(3)+"\"></input><br><br>&nbspType: <input list=\"browsers\" name=\"type\" value=\""+a+"\" /><datalist id=\"browsers\"><option value=\"starter\"><option value=\"Rice\"><option value=\"Non Veg\"><option value=\"Veg\"><option value=\"Dessert\"></datalist></h5><h5>Image: <input type=\"text\" name=\"image\" value=\""+rss.getString(5)+"\"></input><br><center>(eg. format menu/av--.jpg)</center><br><br><input type=\"submit\" value=\"Update Item\"></input></h5></form>");	
			}
			
		}
		else{
			out.print("<h3><center>UPDATE ITEM OF MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>");
			out.print("<center><h3>Plz enter Correct id</h3><br><br>");
			out.print("<form action='menuitemedit.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
		}
	}
	else{
		out.print("<h3><center>UPDATE ITEM OF MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>");
		out.print("<center><h3>Plz enter id field</h3><br><br>");
		out.print("<form action='menuitemedit.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
	}
	
	
}
catch(Exception e){
	out.print("<h3><center>UPDATE ITEM OF MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>");
	out.print("<center><h3>"+e+"</h3><br><br>");
	out.print("<form action='menuitemedit.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
}
%>
</body>
</html>
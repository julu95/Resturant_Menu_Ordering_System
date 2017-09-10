<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <html>
    <head>
    <script>
function goBack() {
    window.history.back();
}
</script>
    </head>
    
    <body>
<% 
String id=request.getParameter("id");
String name=request.getParameter("name");
String price=request.getParameter("price");
String type=request.getParameter("type");
String img=request.getParameter("image");
//String s="1";
//String s="sipusoumya8@gmail.com";
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
		if(id.trim().toCharArray().length!=0 && name.trim().toCharArray().length!=0 && price.trim().toCharArray().length!=0 && type.trim().toCharArray().length!=0 && img.trim().toCharArray().length!=0 ){
			if(id.substring(0, 2).equals("av") && img.substring(0,7).equals("menu/av")){
				String qq="select menuid from avishmya";
				Statement stt=con.createStatement();
				ResultSet rss=stt.executeQuery(qq);
				boolean kk=true;
				while(rss.next())
				{
					if(id.toString().trim().equals(rss.getString(1))){
						kk=false;
						break;
					}
				}
				if(kk){
					
					String str="";
					if(type.equals("starter")) str="1";
					else if(type.equals("Rice")) str="2";
					else if(type.equals("Non Veg")) str="3";
					else if(type.equals("Veg")) str="4";
					else str="5";
					String q="insert into avishmya values(?,?,?,?,?) ";
					PreparedStatement pst;
					pst = con.prepareStatement(q);
					pst.setString(1, id);
					pst.setString(2, name);
					pst.setString(3, price);
					pst.setString(4, str);
					pst.setString(5, img);	
					int st=pst.executeUpdate();
					if(st==1)
					{			
						out.print("<h3><center>ADD ITEM INTO MENU</center></h3><hr><marquee><b>Avishmya Restaurant Add Item</b></marquee><hr>");
						out.print("<center><h3>Sucessfully Item Inserted</h3><br<br>");
						out.print("<form action='menuitemadd.jsp' method='post'><input type='submit' name='b' value='Back'></center></form>");
					}
				}
				else{						
					out.print("<h3><center>ADD ITEM INTO MENU</center></h3><hr><marquee><b>Avishmya Restaurant Add Item</b></marquee><hr>");
					out.print("<center><h3>Entry id is allready used</h3><br><br>");
					out.print("<button onclick=\"goBack()\">Back</button></center>");
				}
					
					
			}
			else
			{
				out.print("<h3><center>ADD ITEM INTO MENU</center></h3><hr><marquee><b>Avishmya Restaurant Add Item</b></marquee><hr>");
				out.print("<center><h3>plz enter correctly</h3><br><br>");
				out.print("<button onclick=\"goBack()\">Back</button></center>");
			}
	}
	else{
		
		out.print("<h3><center>ADD ITEM INTO MENU</center></h3><hr><marquee><b>Avishmya Restaurant Add Item</b></marquee><hr>");
		out.print("<center><h3>Plz eneter all field</h3><br><br>");
	out.print("<button onclick=\"goBack()\">Back</button></center>");
	}
	
	
}
catch(Exception e){
	
	out.print("<h3><center>ADD ITEM INTO MENU</center></h3><hr><marquee><b>Avishmya Restaurant Add Item</b></marquee><hr>");
	out.print("<center><h3>"+e+"</h3><br><br>");
	out.print("<button onclick=\"goBack()\">Back</button></center>");}

%>
</body>
    </html>
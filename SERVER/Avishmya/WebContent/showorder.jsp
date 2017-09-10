<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String code=request.getParameter("code");
Statement st,stt;
ResultSet rs,rss;
Connection con;
String codearr[]=code.trim().split(",");
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String str="";
	int sl=1;
	boolean k=false;
	for(int i=0;i<codearr.length;i++){
		 String codee[]=codearr[i].split("=");
		 String qq="select * from avishmya where menuid=\'"+codee[0]+"\'";
		 stt=con.createStatement();
		 rss=stt.executeQuery(qq);
		 while(rss.next())
			{
			 if(k){str=str+"&";}
			 str=str+"{\"sl\":\""+sl+"\",\"name\":\""+rss.getString(2)+"\",\"imageurl\":\""+rss.getString(5)+"\",\"quantity\":\""+codee[1]+"\",\"price\":\""+(Integer.parseInt(codee[1])*Integer.parseInt(rss.getString(3)))+"\"}";
			 k=true;
			 sl++;
			}
	   }
	out.print(str);
	con.close();
	
}
catch(Exception e){e.printStackTrace();out.print(e);}
%>

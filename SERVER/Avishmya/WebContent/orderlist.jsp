<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String code=request.getParameter("code");
Statement st,stt,sttt;
ResultSet rs,rss;
Connection con;
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select * from AVISHMYAITEMORDER where code=\'"+code+"\'";
	 st=con.createStatement();
	 rs=st.executeQuery(q);
	String str="";
	int sl=1;
	int total=0;
	String name="",imageurl="",no="0",price="0";
	 boolean k=false; 
	while(rs.next())
	{
		no=rs.getString(3);
		String qq="select * from avishmya where menuid=\'"+rs.getString(2)+"\'";
		 stt=con.createStatement();
		 rss=stt.executeQuery(qq);
		 while(rss.next())
			{
				name=rss.getString(2);
				imageurl=rss.getString(5);
				price=rss.getString(3);
			}
		 if(k){str=str+"&";}
		 total=total+(Integer.parseInt(no)*Integer.parseInt(price));
		 //str=str+"{\"sl\":\""+sl+"\",\"name\":\""+name+"\",\"imageurl\":\""+imageurl+"\",\"quantity\":\""+no+"\",\"price\":\""+(Integer.parseInt(no)*Integer.parseInt(price))+"\"}";
		 str=str+sl+" : "+name+" X "+no+" = "+(Integer.parseInt(no)*Integer.parseInt(price));
			k=true; sl++;
	}
	out.print(str);
	String qq="UPDATE avishmyaadmin SET total="+total+"where code='"+code+"'";
	sttt=con.createStatement();
	sttt.executeUpdate(qq);
	
	con.close();
	
}
catch(Exception e){e.printStackTrace();out.print(e);}
%>

<%@ page import="com.cygnus.util.StockService" %>
<%@ page import="java.util.Date" %>


index.jsp
<%
	out.println("Calling StockService");
	StockService service = new StockService();
	out.println(service.getMarketGainers(new Date()));
	out.println("Done Calling StockService");
%>

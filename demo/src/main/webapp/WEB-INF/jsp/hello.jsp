<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %>

<%--  <fmt:setLocale value="de"/>

<fmt:setBundle basename="messages"/> --%>

<html>

<head>

    <title>PhraseApp - i18n</title>

</head>

<body>
<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("messages");
 // String name=resource.getString("language.change");
  String english=resource.getString("welcome.message"); %>
 <%-- <%=english%> --%>
 
 <% ResourceBundle resource_de = ResourceBundle.getBundle("messages_de");
 // String name=resource.getString("language.change");
  String german=resource_de.getString("welcome.message.de"); %>
  <%-- <%=german%> --%>

    <h2>
    </h2>
    <form> 
    <select name="langugeId"> 
    <option value="english">English</option> 
    <option value="german">German</option> 
  </select> 
   <input type="submit" value="Submit"> 
</form> 

 <% 
String languge = request.getParameter("langugeId"); 
%> 
 <% if(languge!=null && languge.equals("english")) { %>
         <%=english%>
      <% } if (languge!=null && languge.equals("german")){ %>
         <%=german%>
      <% } %>
  <%-- <%=productSelected%> --%>

</body>

</html>
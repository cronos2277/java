<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estruturas em JSP</title>
</head>
<body>
  <h3>Exemplo com o for:</h3>
  <%
      String tab = "";
      tab += " <table>";
      tab += " <tr bgcolor='darkgreen'> ";
      tab += " <td>Código</td> " ;
      tab += " <td>Produtos</td> ";
      tab += " </tr> ";
      for(int i=1; i<=10; i++){
          tab += " <tr bgcolor='limegreen'> ";
          tab += " <td>" + i  +"</td> " ;
          tab += " <td>P"+ i +"</td> ";
          tab += " </tr> ";
      }
      tab +=" </table>";
      out.println(tab);
  %>
</body>
</html>
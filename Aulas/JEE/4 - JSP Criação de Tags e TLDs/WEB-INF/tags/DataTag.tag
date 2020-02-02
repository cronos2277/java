<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag import="java.util.Date, java.text.SimpleDateFormat"
    import="java.util.Calendar, java.util.GregorianCalendar" %>
<%@attribute name="data" required="false"%>
<jsp:doBody var="dataCorpo"/>
<strong>
<%
  if(jspContext.getAttribute("dataCorpo") != null)
    data = (String) jspContext.getAttribute("dataCorpo");
  final String[] DIAS = {"","Dom","Seg","Ter","Qua","Qui","Sex","Sab"};
  GregorianCalendar cal = new GregorianCalendar();
  if (data != null && data.length() > 0) {
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    fmt.setLenient(true);
    Date d = fmt.parse(data.trim());
    cal.setTime(d);
  }
  out.print(DIAS[cal.get(Calendar.DAY_OF_WEEK)]);
%>
</strong>
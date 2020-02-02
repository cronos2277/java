package br.com.treinaweb.javaee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Semanatag_comCorpo extends BodyTagSupport {
  static final long serialVersionUID = 1L;
  static final String[] DIAS = {"","Dom","Seg","Ter","Qua","Qui","Sex","Sab"};
  private String data;
  private boolean bodyless = true;

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public int doAfterBody() throws JspException {
    String data = getBodyContent().getString().trim();
    GregorianCalendar cal = new GregorianCalendar();
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    fmt.setLenient(true);
    if (data.length() > 0) {
      Date d = new Date();
      try {
        d = fmt.parse(data);
      }
      catch (Exception e) {
        throw new JspException("Date parsing failed: " + e.getMessage());
      }
      cal.setTime(d);
      try {
        getPreviousOut().print(DIAS[cal.get(Calendar.DAY_OF_WEEK)]);
      }
      catch (Exception e) {
        throw new JspException("Weekday writing failed: " + e.getMessage());
      }
      bodyless = false;
    }
    return SKIP_BODY;
  }

  public int doEndTag() throws JspException {
    if(bodyless){
      GregorianCalendar cal = new GregorianCalendar();
      SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
      fmt.setLenient(true);
      if (data != null && data.length() > 0) {
        Date d = new Date();
        try {
          d = fmt.parse(data);
        }
        catch (Exception e) {
          throw new JspException("Date parsing failed: " + e.getMessage());
        }
        cal.setTime(d);
      }

      try {
        pageContext.getOut().print(DIAS[cal.get(Calendar.DAY_OF_WEEK)]);
      }
      catch (Exception e) {
        throw new JspException("Weekday writing failed: " + e.getMessage());
      }
    }
    return EVAL_PAGE;
  }
}
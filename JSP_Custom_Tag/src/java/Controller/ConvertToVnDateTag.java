/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;


import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class ConvertToVnDateTag extends SimpleTagSupport {
   
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            if (value != null && !value.isEmpty()) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy");
                SimpleDateFormat outputFormat = new SimpleDateFormat("Ngay dd Thang MM Nam yyyy");

                Date date = inputFormat.parse(value);
                String vnDate = outputFormat.format(date);

                out.write(vnDate);
            } else {
                out.write("Invalid date format");
            }

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException | ParseException ex) {
            throw new JspException("Error in ConvertToVnDate tag", ex);
        }
    }


}

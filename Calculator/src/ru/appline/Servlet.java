package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Calculator;
import ru.appline.logic.Form;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/servlet")

public class Servlet extends HttpServlet {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

 /*   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        double val1 = Double.parseDouble(request.getParameter("value1"));
        double val2 = Double.parseDouble(request.getParameter("value2"));
        String operator = request.getParameter("operator");

        Calculator calculator = new Calculator(val1,val2,operator);
        PrintWriter pw = response.getWriter();

        double answer = calculator.calculate();

        pw.print("<html>"+"<body>"+
                "<h1>"+val1+operator+val2+"="+answer+"</h1>"+"</body>"+"</html>");
    }*/

    Form form = Form.getInstance();
    protected void doPost(HttpServletRequest request,HttpServletResponse response ) throws IOException{
        StringBuffer jb = new StringBuffer();
        String line;
        try{
            BufferedReader reader = request.getReader();
            while ((line= reader.readLine())!= null){
                jb.append(line);
            }
        }catch (Exception e){
            System.out.println("Error");
        }
        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);



        Double val1 = jobj.get("value1").getAsDouble();
        String operator = jobj.get("operator").getAsString();
        Double val2 = jobj.get("value2").getAsDouble();

        Calculator calculator = new Calculator(val1,val2,operator);
        double answer = calculator.calculate();

        Double answ = jobj.get(String.valueOf(answer)).getAsDouble();

        response.setContentType("application/json;charset=utf-8");

        PrintWriter pw = response.getWriter();


        pw.print(gson.toJson(form.getFormList()));

    }
}

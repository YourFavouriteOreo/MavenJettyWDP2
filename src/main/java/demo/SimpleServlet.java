package demo;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.samskivert.mustache.*;

@WebServlet(urlPatterns = "/process")
public class SimpleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HashMap<String, Object> scopes = new HashMap<String, Object>();
        PrintWriter out = response.getWriter();
        FileReader freader = new FileReader(new File(System.getProperty("user.dir")+"\\src\\main\\java\\demo\\template.mustache"));
        Template tmpl = Mustache.compiler().compile(freader);
        scopes.put("three", "five");
        out.print(tmpl.execute(scopes));
        out.flush();
        out.close();
    }
}
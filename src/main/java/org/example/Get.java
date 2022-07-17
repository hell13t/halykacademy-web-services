package org.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "get", value = "/get")
public class Get extends HttpServlet {

    ArrayList<Organizations> orgs = new ArrayList<>(){
        {
            add(new Organizations(1L, "Title1", "Address1", new Date().toString()));
            add(new Organizations(2L, "Title2", "Address2", new Date().toString()));
            add(new Organizations(3L, "Title3", "Address3", new Date().toString()));
        }
    };

    public Get() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String orgAsString = objectMapper.writeValueAsString(orgs);

        try {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(orgAsString);
            out.close();
        } catch (UnsupportedEncodingException e) {
            System.err.print("UnsupportedEncoding");
        } catch (IOException e) {
            System.err.print("IOException");
        }
    }
}



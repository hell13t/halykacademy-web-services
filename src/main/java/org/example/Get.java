package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "get", value = "/get")
public class Get extends HttpServlet {

    ArrayList<Organizations> orgs = new ArrayList<>(){
        {
            add(new Organizations(1L, "Title1", "Address1", LocalDate.now()));
            add(new Organizations(2L, "Title2", "Address2", LocalDate.now()));
            add(new Organizations(3L, "Title3", "Address3", LocalDate.now()));
        }
    };

    public Get() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File("target/org.json"), orgs.get(0));
        String orgAsString = objectMapper.writeValueAsString(orgs);


        try {
            // установка MIME-типа содержания ответа
            response.setContentType("text/html; charset=UTF-8");
            // поток для данных ответа
            PrintWriter out = response.getWriter();
            out.println(orgAsString);
//            count = ClickOutput.printClick(out, count);
            // обращение к классу бизнес-логики
//            if(count == 1)
//                RequestInfo.printToBrowser(out, req);
            // закрытие потока
            out.close();
        } catch (UnsupportedEncodingException e) {
            System.err.print("UnsupportedEncoding");
        } catch (IOException e) {
            System.err.print("IOException");
        }
    }
}



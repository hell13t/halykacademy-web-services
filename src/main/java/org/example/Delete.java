package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "delete", value = "/delete")
public class Delete extends HttpServlet {

    ArrayList<Organizations> orgs = new ArrayList<>(){
        {
            add(new Organizations(1L, "Title1", "Address1", LocalDate.now()));
            add(new Organizations(2L, "Title2", "Address2", LocalDate.now()));
            add(new Organizations(3L, "Title3", "Address3", LocalDate.now()));
        }
    };

    public Delete() {
        super();
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // установка MIME-типа содержания ответа
            response.setContentType("text/html; charset=UTF-8");
            // поток для данных ответа
            PrintWriter out = response.getWriter();
            out.println("Done");
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



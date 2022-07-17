package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "put", value = "/put")
public class Put extends HttpServlet {

    ArrayList<Organizations> orgs = new ArrayList<>(){
        {
            add(new Organizations(1L, "Title1", "Address1", new Date().toString()));
            add(new Organizations(2L, "Title2", "Address2", new Date().toString()));
            add(new Organizations(3L, "Title3", "Address3", new Date().toString()));
        }
    };

    public Put() {
        super();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        Long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String address = request.getParameter("address");
        String creationDate = request.getParameter("creationDate");

        Organizations var = new Organizations(id, title, address, creationDate);
        orgs.add(var);
    }
}



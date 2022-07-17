package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@WebServlet(name = "delete", value = "/delete")
public class Delete extends HttpServlet {

    ArrayList<Organizations> orgs = new ArrayList<>(){
        {
            add(new Organizations(1L, "Title1", "Address1", new Date().toString()));
            add(new Organizations(2L, "Title2", "Address2", new Date().toString()));
            add(new Organizations(3L, "Title3", "Address3", new Date().toString()));
        }
    };

    public Delete() {
        super();
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        for (int i = 0; i < orgs.size(); i++){
            if (Objects.equals(orgs.get(i).id, id)){
                orgs.remove(orgs.get(i));
            }
        }
    }
}



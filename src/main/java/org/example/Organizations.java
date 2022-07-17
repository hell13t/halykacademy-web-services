package org.example;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.Date;

public class Organizations {
    Long id;
    String title;
    String address;
    String creationDate;

    public Organizations(Long id, String title, String address, String creationDate) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.creationDate = creationDate;
    }

}

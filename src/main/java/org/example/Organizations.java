package org.example;

import java.time.LocalDate;

public class Organizations {
    Long id;
    String title;
    String address;
    LocalDate creationDate;

    public Organizations(Long id, String title, String address, LocalDate creationDate) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.creationDate = creationDate;
    }
}

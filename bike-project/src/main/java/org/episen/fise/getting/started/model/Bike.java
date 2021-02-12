package org.episen.fise.getting.started.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bike {

    private String model;
    private String price;
    private String identifications;
    private String owner;

    public Bike(String model, String price, String identifications) {
        this.model = model;
        this.price = price;
        this.identifications = identifications;
    }
}

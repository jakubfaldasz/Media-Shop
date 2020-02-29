package com.jfaldasz.mediashop.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    private String modelName;
    private Float price;
    private String pathToImage;
    @Enumerated(EnumType.STRING)
    private Type productType;

    public static enum Type {
        SMARTPHONE, TV, GAMING_CONSOLE, NOTEBOOK
    }
}

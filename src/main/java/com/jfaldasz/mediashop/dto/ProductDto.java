package com.jfaldasz.mediashop.dto;

import com.jfaldasz.mediashop.model.Product;
import lombok.*;

@Data
@NoArgsConstructor
public class ProductDto {

    public ProductDto(String manufacturer, String modelName, Float price, String pathToImage, Product.Type productType) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.price = price;
        this.pathToImage = pathToImage;
        this.productType = productType;
    }

    private Long id;
    private String manufacturer;
    private String modelName;
    private Float price;
    private String pathToImage;
    private Product.Type productType;
}

package com.jfaldasz.mediashop.repository;

import com.jfaldasz.mediashop.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByManufacturer(String manufacturer);
    List<Product> findByPriceBetween(Float minPrice, Float maxPrice);
    List<Product> findByProductType(Product.Type productType);
}

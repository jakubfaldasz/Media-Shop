package com.jfaldasz.mediashop.service;

import com.jfaldasz.mediashop.dto.ProductDto;
import com.jfaldasz.mediashop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDto findById(Long id);
    List<ProductDto> findByManufacturer(String manufacturer);
    List<ProductDto> findProductsInPriceRange(Float minPrice, Float maxPrice);
    List<ProductDto> findByProductType(Product.Type productType);
    List<ProductDto> getAll();
    List<ProductDto> addProduct(ProductDto productDto);

}

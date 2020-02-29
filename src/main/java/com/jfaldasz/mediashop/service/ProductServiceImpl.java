package com.jfaldasz.mediashop.service;

import com.jfaldasz.mediashop.dto.ProductDto;
import com.jfaldasz.mediashop.model.Product;
import com.jfaldasz.mediashop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto findById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()) {
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            return productDto;
        } else
            return null;

    }

    @Override
    public List<ProductDto> findByManufacturer(String manufacturer) {
        List<Product> foundProducts = productRepository.findByManufacturer(manufacturer);

        if(!foundProducts.isEmpty())
            return foundProducts.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
         else
            return Collections.emptyList();

    }

    @Override
    public List<ProductDto> findProductsInPriceRange(Float minPrice, Float maxPrice) {
        List<Product> foundProducts = productRepository.findByPriceBetween(minPrice, maxPrice);

        if(!foundProducts.isEmpty())
            return foundProducts.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
        else
            return Collections.emptyList();

    }

    @Override
    public List<ProductDto> findByProductType(Product.Type productType) {
        List<Product> productsOfRequestedType = productRepository.findByProductType(productType);

        if(!productsOfRequestedType.isEmpty())
            return productsOfRequestedType.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
        else
            return Collections.emptyList();

    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> allProducts = StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());

        if(!allProducts.isEmpty())
            return allProducts.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
        else
            return Collections.emptyList();
    }

    @Override
    public List<ProductDto> addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);

        productRepository.save(product);

        return getAll();
    }
}

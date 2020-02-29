package com.jfaldasz.mediashop.controller;

import com.jfaldasz.mediashop.dto.ProductDto;
import com.jfaldasz.mediashop.model.Product;
import com.jfaldasz.mediashop.repository.ProductRepository;
import com.jfaldasz.mediashop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;

        List<ProductDto> productsToInsert = Arrays.asList(
                new ProductDto("Xiaomi", "Mi 9", 1200f, "/smartphones/xiaomi.png", Product.Type.SMARTPHONE),
                new ProductDto("Apple", "iPhone 11Pro", 4200f, "/smartphones/iphone.png", Product.Type.SMARTPHONE),
                new ProductDto("Huawei", "P30 Pro", 2800f, "/smartphones/huawei.png", Product.Type.SMARTPHONE),
                new ProductDto("Samsung", "Galaxy S10", 3600f, "/smartphones/samsung.png", Product.Type.SMARTPHONE),
                new ProductDto("Sony", "PS4 Pro", 1600f, "/consoles/ps4.png", Product.Type.GAMING_CONSOLE),
                new ProductDto("Microsoft", "Xbox One X", 1800f, "/consoles/xbox.png", Product.Type.GAMING_CONSOLE),
                new ProductDto("Nintendo", "Switch", 1400f, "/consoles/switch.png", Product.Type.GAMING_CONSOLE),
                new ProductDto("LG", "LG tv 55\"", 6500f, "/tvs/lg.png", Product.Type.TV),
                new ProductDto("Sony", "OLED 60\"", 7540f, "/tvs/sony.png", Product.Type.TV),
                new ProductDto("Samsung", "QLED 65\"", 8500f, "/tvs/samsung.png", Product.Type.TV)
        );

        productsToInsert.forEach(p -> productService.addProduct(p));
    }

    @GetMapping
    public String showAllProducts(Model model) {

        model.addAttribute("products", productService.getAll());

        return "home";

    }

//    @GetMapping
//    public @ResponseBody Iterable<ProductDto> getAllProducts() {
//        return productService.getAll();
//    }


}

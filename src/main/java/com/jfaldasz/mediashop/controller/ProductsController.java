package com.jfaldasz.mediashop.controller;

import com.jfaldasz.mediashop.model.Product;
import com.jfaldasz.mediashop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/smartphones")
    public String displaySmartphones(Model model) {
        model.addAttribute("products", productService.findByProductType(Product.Type.SMARTPHONE));
        model.addAttribute("activeSection", "smartphones");

        return "productsOfType";
    }

    @GetMapping("/tvs")
    public String displayTVs(Model model) {
        model.addAttribute("products", productService.findByProductType(Product.Type.TV));
        model.addAttribute("activeSection", "tvs");

        return "productsOfType";
    }

    @GetMapping("/consoles")
    public String displayConsoles(Model model) {
        model.addAttribute("products", productService.findByProductType(Product.Type.GAMING_CONSOLE));
        model.addAttribute("activeSection", "consoles");

        return "productsOfType";
    }

}

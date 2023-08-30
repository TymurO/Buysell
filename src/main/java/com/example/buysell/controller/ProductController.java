package com.example.buysell.controller;

import com.example.buysell.module.Product;
import com.example.buysell.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getProducts(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("products", productService.getProductsByName(name));
        return "index";
    }

    @PostMapping("/new")
    public String addProduct(Product product, @RequestParam("file") MultipartFile file) throws IOException {
        productService.saveProduct(product, file);
        return "redirect:/products";
    }

    @GetMapping("/new")
    public String getAddForm() {
        return "create_product";
    }

    @GetMapping("/admin")
    public ResponseEntity<?> admin() {
        return ResponseEntity.ok("Admin data");
    }

    @GetMapping("/info")
    public ResponseEntity<?> info(Principal principal) {
        return ResponseEntity.ok(principal.getName());
    }

    @GetMapping("/secured")
    public ResponseEntity<?> secured() {
        return ResponseEntity.ok("Secured part");
    }

    @GetMapping("/unsecured")
    public ResponseEntity<?> unsecured() {
        return ResponseEntity.ok("Unsecured part");
    }
}

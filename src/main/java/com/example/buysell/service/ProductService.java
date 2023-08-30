package com.example.buysell.service;

import com.example.buysell.module.Image;
import com.example.buysell.module.Product;
import com.example.buysell.repository.ProductRepository;
import com.example.buysell.util.ImageUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Collection<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void saveProduct(Product product, MultipartFile file) throws IOException {
        Image image = ImageUtils.toImageFromFile(file);
        product.setImage(image);
        productRepository.save(product);
    }

    @Transactional
    public Collection<Product> getProductsByName(String name) {
        if (name != null) {
            return productRepository.getProductsByName(name);
        }
        else {
            return productRepository.getAllProducts();
        }
    }
}

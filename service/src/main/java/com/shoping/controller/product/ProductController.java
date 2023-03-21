package com.shoping.controller.product;

import com.shoping.entity.product.Product;
import com.shoping.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/product/add-all")
    public List<Product> createProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/product/get-all")
    public List<Product> getAllProducts() {
        return service.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping("/product")
    public Product updateProductByName(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}

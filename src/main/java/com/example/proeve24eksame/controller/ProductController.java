package com.example.proeve24eksame.controller;

import com.example.proeve24eksame.model.Product;
import com.example.proeve24eksame.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//hej
@RestController
@RequestMapping("/Products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product createdProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
        public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            updatedProduct.setProductId(id);
            Product savedProduct = productRepository.save(updatedProduct);
            return ResponseEntity.ok().body(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return ResponseEntity.ok("Product deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.example.proeve24eksame.config;

import com.example.proeve24eksame.model.Product;
import com.example.proeve24eksame.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product();
        product1.setName("Æble");
        product1.setPrice(5);
        product1.setWeight(150);
        productRepository.save(product1);

    }

}

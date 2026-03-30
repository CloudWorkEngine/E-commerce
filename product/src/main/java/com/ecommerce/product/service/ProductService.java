package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){

        List<Product> products = productRepository.findAll();

        if(products.isEmpty())
            return null;

        return products;
    }

    public List<Product> getProductsByName(String name){
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);

        if(products.isEmpty())
             return null;

        return products;
    }

    public Product getProductById(String id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
}
package com.jeffliggett.resftulapi.restful_api.controller;

import com.jeffliggett.resftulapi.restful_api.model.Product;
import com.jeffliggett.resftulapi.restful_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // insert a product into the database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // get a single product by its ID
    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam(name = "productId") long productId) {
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // get all products in the database table
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // update an existing item in the database
    @PatchMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "productId") long productId, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // delete an existing item in the database
    @DeleteMapping("/product")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "productId") long productId) {
        Product deletedProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    // get an item by name from the database using a raw SQL statement
    @GetMapping("/products-by-name")
    public List<Product> getProductsByName(@RequestParam(name = "productName") String productName) {
        return productService.getProductsByName(productName);
    }

}

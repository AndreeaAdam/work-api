package org.example.controller;

import org.example.dto.ProductDto;
import org.example.exception.ProductNotFoundException;
import org.example.exception.WorkApiException;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductController {
    @Autowired
    private ProductService service;
    ResponseEntity responseEntity;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        try {
            responseEntity = new ResponseEntity(service.saveProduct(productDto), HttpStatus.OK);
        } catch (WorkApiException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
    @PutMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        try {
            responseEntity = new ResponseEntity(service.saveProduct(productDto), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(service.deleteProduct(id), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @GetMapping("/products")
    public  ResponseEntity<List<ProductDto>> getProductList() {
        return new ResponseEntity<>(service.getProductList(), HttpStatus.OK);
    }

}

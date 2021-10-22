package com.rookie.rookie.controller;

import com.rookie.rookie.domain.Category;
import com.rookie.rookie.domain.Product;
import com.rookie.rookie.dto.ProductDto;
import com.rookie.rookie.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return ResponseEntity.ok(
                this.productService.findAll().stream().map(
                        e -> new ProductDto(e.getProductId(), e.getName(), e.getPrice(), e.getImages(), e.getCreateDate(), e.getUpdateDate(),
                                e.getCategory().getCategoryId()
                        )).collect(Collectors.toList()));
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getOne(@PathVariable("id") Integer id){
        Optional<Product> opt = productService.findById(id);
        if(opt.isPresent()){
            Product p = opt.get();
            return ResponseEntity.ok(
                    new ProductDto(p.getProductId(),p.getName(),p.getPrice(),p.getImages(),p.getCreateDate(),p.getUpdateDate(),p.getCategory().getCategoryId())
            );
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody ProductDto dto) {
        try{
            Product p = new Product();
            BeanUtils.copyProperties(dto,p);

            Category cate = new Category();
            cate.setCategoryId(dto.getCategoryId());
            p.setCategory(cate);
            productService.save(p);
            return new ResponseEntity<>(p,HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id,@Validated @RequestBody ProductDto dto){
        Optional<Product> opt = productService.findById(id);

        if(opt.isPresent()){
            Product product = opt.get();
            product.setName(dto.getName());
            product.setPrice(dto.getPrice());
            product.setImages(dto.getImages());
            product.setCreateDate(dto.getCreateDate());
            product.setUpdateDate(dto.getUpdateDate());

            Category cate = new Category();
            cate.setCategoryId(dto.getCategoryId());
            product.setCategory(cate);
            return new ResponseEntity<>(productService.save(product),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Integer id){
        try{
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

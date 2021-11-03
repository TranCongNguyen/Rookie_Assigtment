package com.rookie.shop.controller;

import com.rookie.shop.constant.ErrorCode;
import com.rookie.shop.converter.ProductConverter;
import com.rookie.shop.dto.ProductDto;
import com.rookie.shop.dto.ResponseDto;
import com.rookie.shop.entity.Product;
import com.rookie.shop.exception.*;
import com.rookie.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping(path = "api/v1/product")
public class ProductManagerController {
    @Autowired
    private  ProductConverter productConverter;

    @Autowired
    private  ProductService productService;


    @PostMapping
    public ResponseEntity<ResponseDto> saveProduct(@Valid @RequestBody ProductDto productDto) throws ConvertDtoException, SaveErrorException, CategoryIdNotFound, ProductIdNotFoundException, BrandIdNotFoundException {
        Product productRequest = productConverter.ConverterToEntity(productDto);
        ResponseDto responseDto = productService.saveProduct(productRequest);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> searchAllProduct(Pageable page) throws ConvertDtoException {
        ResponseDto responseDto = productService.searchAllProduct(page);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> searchOneProduct(@PathVariable("id") Long id) throws ProductIdNotFoundException, ConvertDtoException {
        ResponseDto responseDto = productService.searchOneProduct(id);
        return ResponseEntity.ok(responseDto);
    }


}

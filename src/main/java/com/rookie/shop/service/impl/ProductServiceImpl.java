package com.rookie.shop.service.impl;

import com.rookie.shop.constant.ErrorCode;
import com.rookie.shop.constant.SuccessCode;
import com.rookie.shop.converter.ProductConverter;
import com.rookie.shop.dto.ProductDto;
import com.rookie.shop.dto.ResponseDto;
import com.rookie.shop.entity.Product;
import com.rookie.shop.exception.*;
import com.rookie.shop.repository.BrandRepository;
import com.rookie.shop.repository.CategoryRepository;
import com.rookie.shop.repository.ProductDetailRepository;
import com.rookie.shop.repository.ProductRepository;
import com.rookie.shop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private  CategoryRepository categoryRepository;
    @Autowired
    private  BrandRepository brandRepository;
    @Autowired
    private  ProductDetailRepository productDetailRepository;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private ProductConverter productConverter;


    @Override
    public ResponseDto saveProduct(Product product) throws SaveErrorException, ProductIdNotFoundException, CategoryIdNotFound, BrandIdNotFoundException {
     return null;
    }

    @Override
    public ResponseDto searchAllProduct(Pageable page) throws ConvertDtoException {
        ResponseDto responseDto = new ResponseDto();
        Page<Product> products = productRepository.findAll(page);
        List<ProductDto> productDto = products.stream().map(product ->modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        responseDto.setData(productDto);
        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_ALL_PRODUCT);
        return responseDto;
    }

    @Override
    public ResponseDto searchOneProduct(Long id) throws ProductIdNotFoundException, ConvertDtoException {
        ResponseDto responseDto = new ResponseDto();
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductIdNotFoundException(ErrorCode.ERR_PRODUCT_ID_NOT_FOUND));
        ProductDto productDto = productConverter.converterToDTO(product);
        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_PRODUCT);
        responseDto.setData(productDto);
        return  responseDto;
    }




}

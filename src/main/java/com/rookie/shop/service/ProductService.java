package com.rookie.shop.service;

import com.rookie.shop.dto.ResponseDto;
import com.rookie.shop.entity.Product;
import com.rookie.shop.exception.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ResponseDto saveProduct(Product product) throws SaveErrorException, ProductIdNotFoundException, CategoryIdNotFound, BrandIdNotFoundException;

    ResponseDto searchAllProduct(Pageable page) throws ConvertDtoException;

    ResponseDto searchOneProduct(Long id) throws ProductIdNotFoundException, ConvertDtoException;


}

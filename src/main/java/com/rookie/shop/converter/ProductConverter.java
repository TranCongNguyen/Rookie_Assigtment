package com.rookie.shop.converter;

import com.rookie.shop.constant.ErrorCode;
import com.rookie.shop.dto.ProductDto;
import com.rookie.shop.entity.Product;
import com.rookie.shop.exception.ConvertDtoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Product ConverterToEntity(ProductDto productDto) throws ConvertDtoException{
        try{
            Product product = modelMapper.map(productDto, Product.class);
            product.getBrand().setId(productDto.getBrandId());
            product.getCategory().setId(productDto.getCategoryId());
            return product;
        }catch (Exception e){
            e.printStackTrace();
            throw new ConvertDtoException(ErrorCode.ERR_SAVE_PRODUCT);
        }
    }

    public ProductDto converterToDTO(Product product) throws ConvertDtoException{
        try{
            ProductDto productDto = modelMapper.map(product,ProductDto.class);
            productDto.setCategoryId(product.getCategory().getId());
            productDto.setBrandId(product.getBrand().getId());
            return productDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new ConvertDtoException(ErrorCode.ERR_CONVERTER);
        }
    }
}

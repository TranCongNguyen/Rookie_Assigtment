package com.rookie.shop.service.impl;

import com.rookie.shop.constant.SuccessCode;
import com.rookie.shop.dto.BrandDto;
import com.rookie.shop.dto.ResponseDto;
import com.rookie.shop.entity.Brand;
import com.rookie.shop.repository.BrandRepository;
import com.rookie.shop.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseDto retrieveBrand() {
        ResponseDto responseDto = new ResponseDto();
        List<Brand> brands = brandRepository.findAll();
        List<BrandDto> brandDto = brands.stream().map(brand -> modelMapper.map(brand,BrandDto.class)).collect(Collectors.toList());
        responseDto.setData(brandDto);
        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_ALL_BRAND);
        return responseDto;
    }
}

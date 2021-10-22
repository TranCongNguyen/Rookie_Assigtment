package com.rookie.rookie.service.impl;

import com.rookie.rookie.domain.Product;
import com.rookie.rookie.repository.ProductDAO;
import com.rookie.rookie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO dao;

    @Override
    public List<Product> findAll(Sort sort) {
        return dao.findAll(sort);
    }

    @Override
    public List<Product> findAllById(Iterable<Integer> integers) {
        return dao.findAllById(integers);
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return dao.saveAll(entities);
    }

    @Override
    public void flush() {
        dao.flush();
    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        return dao.saveAndFlush(entity);
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return dao.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Product> entities) {
        dao.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {
        dao.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        dao.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {
        dao.deleteAllInBatch();
    }

    @Override
    public Product getById(Integer integer) {
        return dao.getById(integer);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return dao.findAll(example);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return dao.findAll(example, sort);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public <S extends Product> S save(S entity) {
        return dao.save(entity);
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return dao.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return dao.existsById(integer);
    }

    @Override
    public long count() {
        return dao.count();
    }

    @Override
    public void deleteById(Integer integer) {
        dao.deleteById(integer);
    }

    @Override
    public void delete(Product entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        dao.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        dao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return dao.findOne(example);
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return dao.findAll(example, pageable);
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return dao.count(example);
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return dao.exists(example);
    }

    @Override
    public List<Product> findAll(){
        return dao.findAll();
    }



}

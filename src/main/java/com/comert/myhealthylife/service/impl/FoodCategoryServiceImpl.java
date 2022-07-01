package com.comert.myhealthylife.service.impl;

import com.comert.myhealthylife.exception.EntityNotFoundException;
import com.comert.myhealthylife.model.entity.FoodCategory;
import com.comert.myhealthylife.repository.FoodCategoryRepository;
import com.comert.myhealthylife.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    private final Supplier<EntityNotFoundException> entityNotFoundExceptionSupplier = EntityNotFoundException::new;

    @Override
    public void save(FoodCategory entity) {
        foodCategoryRepository.save(entity);
    }

    @Override
    public FoodCategory findById(Integer id) throws EntityNotFoundException {
        final Optional<FoodCategory> foodCategory = foodCategoryRepository.findById(id);
        return foodCategory.orElseThrow(entityNotFoundExceptionSupplier);
    }

    @Override
    public FoodCategory update(FoodCategory entity) {
        return foodCategoryRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        foodCategoryRepository.deleteById(id);
    }
}

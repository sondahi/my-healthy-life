package com.comert.myhealthylife.service.impl;

import com.comert.myhealthylife.exception.EntityNotFoundException;
import com.comert.myhealthylife.model.entity.Food;
import com.comert.myhealthylife.repository.FoodRepository;
import com.comert.myhealthylife.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public FoodServiceImpl(){}

    private final Supplier<EntityNotFoundException> entityNotFoundExceptionSupplier = EntityNotFoundException::new;

    @Override
    public void save(Food entity) {
        foodRepository.save(entity);
    }

    @Override
    public Food findById(Integer id) throws EntityNotFoundException {
        final Optional<Food> food = foodRepository.findById(id);
        return food.orElseThrow(entityNotFoundExceptionSupplier);
    }

    @Override
    public Food update(Food entity) {
        return foodRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        foodRepository.deleteById(id);
    }

}

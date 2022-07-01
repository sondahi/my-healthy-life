package com.comert.myhealthylife.repository;

import com.comert.myhealthylife.model.dto.IdAndName;
import com.comert.myhealthylife.model.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    List<IdAndName> findFoodsByIdAndName();

}
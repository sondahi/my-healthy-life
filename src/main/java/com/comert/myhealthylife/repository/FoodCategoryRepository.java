package com.comert.myhealthylife.repository;

import com.comert.myhealthylife.model.dto.IdAndName;
import com.comert.myhealthylife.model.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {

    List<IdAndName> findFoodCategoriesByIdAndName();
    
}
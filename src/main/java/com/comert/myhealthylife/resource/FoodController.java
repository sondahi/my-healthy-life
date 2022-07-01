package com.comert.myhealthylife.resource;

import com.comert.myhealthylife.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/test")
    public void test(){
        foodService.deleteById(1);
    }

}

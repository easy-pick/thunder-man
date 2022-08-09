package com.easypick.thunderMan.controller;

import com.easypick.thunderMan.dto.response.FoodOptionResponse;
import com.easypick.thunderMan.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/*")
@RestController
public class FoodRestController {

    @Autowired
    FoodService foodService;


    @GetMapping("food/{foodId}/option")
    public List<FoodOptionResponse> selectFoodOptions(@PathVariable long foodId){

        List<FoodOptionResponse> foodOptionResponseList =  foodService.getFoodOptions(foodId).stream().map(FoodOptionResponse::from).toList();



        return foodOptionResponseList;

    }
}

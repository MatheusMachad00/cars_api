package com.cars_api.cars_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars_api.cars_api.dto.CarDTO;
import com.cars_api.cars_api.model.Car;
import com.cars_api.cars_api.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/car")
public class CarController {

  @Autowired
  private CarRepository repository;
  
  @PostMapping
  public void create(@RequestBody CarDTO req) {
    repository.save(new Car(req));
  }
  
}

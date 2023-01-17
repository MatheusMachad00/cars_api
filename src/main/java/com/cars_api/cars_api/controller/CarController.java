package com.cars_api.cars_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars_api.cars_api.dto.CarDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/car")
public class CarController {
  
  @PostMapping
  public void create(@RequestBody CarDTO req) {
      System.out.println("O modelo do carro é: " + req.modelo());
      System.out.println("O fabricante do carro é: " + req.fabricante());
      System.out.println("A data de fabricação do carro é: " + req.dataFabricacao());
      System.out.println("O valor do carro é: " + req.valor());
      System.out.println("O ano do carro é: " + req.anoModelo());
  }
  
}

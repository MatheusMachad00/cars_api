package com.cars_api.cars_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars_api.cars_api.dto.CarDTO;
import com.cars_api.cars_api.model.Car;
import com.cars_api.cars_api.repository.CarRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping
  public List<Car> getAll(){
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody CarDTO req){
    repository.findById(id).map(car -> {
      car.setModelo(req.modelo());
      car.setFabricante(req.fabricante());
      car.setDataFabricacao(req.dataFabricacao());
      car.setValor(req.valor());
      car.setAnoModelo(req.anoModelo());

      return repository.save(car);
    });
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){
    repository.deleteById(id);
  }
  
}

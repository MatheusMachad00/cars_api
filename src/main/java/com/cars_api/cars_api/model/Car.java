package com.cars_api.cars_api.model;

import com.cars_api.cars_api.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Car {
  

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 30, nullable = false)
  private String modelo;
  
  @Column(length = 30, nullable = false)
  private String fabricante;

  @Column(length = 30, nullable = false)
  private String dataFabricacao;

  @Column(length = 30, nullable = false)
  private double valor;

  @Column(length = 30, nullable = false)
  private int anoModelo;

  public Car(CarDTO data){
    this.modelo = data.modelo();
    this.fabricante = data.fabricante();
    this.dataFabricacao = data.dataFabricacao();
    this.valor = data.valor();
    this.anoModelo = data.anoModelo();
  }
}

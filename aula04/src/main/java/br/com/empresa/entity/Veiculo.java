package br.com.empresa.entity;

import java.util.UUID;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //isso é pra virar tabela no banco de dados

public class Veiculo {
	
 @Id	
 @GeneratedValue(strategy = GenerationType.UUID)
 private UUID id;
 
 @NotBlank(message="Placa Não Preencida")
 @Size(max = 7, min = 7, message= "Placa Invalida")
 private String placa;
 
 @NotBlank(message="Marca Não Preencida")
 @Size(max = 20)
 private String marca;
 
 @Size(max = 30)
 @NotBlank(message="Modelo Não Preencida")
 private String modelo;
 
 @OneToOne //pra dizer que um proprietario tem um veiculo e um veiculo pertence a um proprietario
 @JoinColumn(name = "id_proprietario")
 private Proprietario proprietario;
 
 
 public Proprietario getProprietario() {
	return proprietario;
}

 public void setProprietario(Proprietario proprietario) {
	this.proprietario = proprietario;
 }

 @Embedded
 private Catacteristica caracteristica;

 public UUID getId() {
	return id;
 }

 public void setId(UUID id) {
	this.id = id;
 }

 public String getPlaca() {
	return placa;
 }

 public void setPlaca(String placa) {
	this.placa = placa;
 }

 public String getMarca() {
	return marca;
 }

 public void setMarca(String marca) {
	this.marca = marca;
 }

 public String getModelo() {
	return modelo;
 }

 public void setModelo(String modelo) {
	this.modelo = modelo;
 }

 public Catacteristica getCaracteristica() {
	return caracteristica;
 }

 public void setCaracteristica(Catacteristica caracteristica) {
	this.caracteristica = caracteristica;
 }
 
 
 
}

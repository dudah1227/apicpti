package br.com.empresa.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable 
public class Catacteristica {
 private String renavam;
 private String chassi;
 private Integer ano;
 private String cor;
 
 @Enumerated(EnumType.STRING)  //pra salvar no banco de dados os dados do enum
 private Categoria categoria;
 
 @Enumerated(EnumType.ORDINAL) //pra salvar os codigo
 private Combustivel combustivel;

 public String getRenavam() {
	return renavam;
 }

 public void setRenavam(String renavam) {
	this.renavam = renavam;
 }

 public String getChassi() {
	return chassi;
 }

 public void setChassi(String chassi) {
	this.chassi = chassi;
 }

 public Integer getAno() {
	return ano;
 }

 public void setAno(Integer ano) {
	this.ano = ano;
 }

 public String getCor() {
	return cor;
 }

 public void setCor(String cor) {
	this.cor = cor;
 }

 public Categoria getCategoria() {
	return categoria;
 }

 public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
 }

 public Combustivel getCombustivel() {
	return combustivel;
 }

 public void setCombustivel(Combustivel combustivel) {
	this.combustivel = combustivel;
 }
 
 
 
 
 
}

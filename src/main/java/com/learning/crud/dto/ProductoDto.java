package com.learning.crud.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductoDto {


	@Min(0)
	private double precio;
	@NotBlank
	private String nombre;
	@NotBlank
	private String tipo;
	@NotBlank
	private String marca;
	private boolean stock;

	public ProductoDto() {
		
	}

	public ProductoDto(@Min(0)double precio,@NotBlank String nombre, @NotBlank String tipo, @NotBlank String marca, boolean stock) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.tipo = tipo;
		this.marca = marca;
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}
}
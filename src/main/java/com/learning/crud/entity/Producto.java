package com.learning.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "tProduct")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "col_precio", length = 50, nullable = false, unique = false)
	private double precio;
	@Column(name = "col_name", length = 50, nullable = false, unique = false)
	private String nombre;
	@Column(name = "col_tipo", length = 50, nullable = false, unique = false)
	private String tipo;
	@Column(name = "col_marca", length = 50, nullable = false, unique = false)
	private String marca;
	@Column(name = "col_stock", length = 50, nullable = false, unique = false)
	private boolean stock;

	public Producto() {
		// Default constructor
	}

	public Producto(double precio, String nombre, String tipo, String marca, boolean stock) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.tipo = tipo;
		this.marca = marca;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


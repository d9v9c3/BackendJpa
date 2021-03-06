package com.learning.crud.controller;

import com.learning.crud.dto.Mensaje;
import com.learning.crud.dto.ProductoDto;
import com.learning.crud.entity.Producto;
import com.learning.crud.service.ProductoService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@GetMapping("/lista")
	public ResponseEntity<List<Producto>> list() {
		System.out.println("test the branch on git");
		List<Producto> list = productoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Producto> getById(@PathVariable("id") int id) {
		System.out.println("I finish my test");
		if (!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getOne(id).get();
		return new ResponseEntity(producto, HttpStatus.OK);
	}

	@GetMapping("/detailname/{nombre}")
	public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre) {
		if (!productoService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getByNombre(nombre).get();
		return new ResponseEntity(producto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductoDto productoDto) {
		if (StringUtils.isBlank(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (productoDto.getPrecio() < 0)
			return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
		if (productoService.existsByNombre(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

		Producto producto = new Producto(productoDto.getPrecio(), productoDto.getNombre(), productoDto.getTipo(),
				productoDto.getMarca(), productoDto.isStock());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductoDto productoDto) {

		if (!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		if (productoService.existsByNombre(productoDto.getNombre())
				&& productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if (StringUtils.isBlank(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (productoDto.getPrecio() < 0)
			return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

		Producto producto = productoService.getOne(id).get();
		producto.setPrecio(productoDto.getPrecio());
		producto.setNombre(productoDto.getNombre());
		producto.setTipo(productoDto.getTipo());
		producto.setMarca(productoDto.getMarca());
		producto.setStock(productoDto.isStock());
		productoService.save(producto);

		return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		productoService.delete(id);
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}

}

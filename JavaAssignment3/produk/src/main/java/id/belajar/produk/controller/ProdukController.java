package id.belajar.produk.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.belajar.produk.entity.Produk;
import id.belajar.produk.service.ProdukService;


@RestController
@RequestMapping("/products")
public class ProdukController {
	@Autowired
	ProdukService produkService;
	
	@GetMapping("")
	public List<Produk> list(){
		return produkService.listAllProduk();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id){
		try {
			Produk produk = produkService.getProduk(id);
			return new ResponseEntity<Produk>(produk, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Produk tidak ditemukan",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/")
	public ResponseEntity<?> add(@RequestBody Produk produk) {
		
		try {
			produkService.saveProduk(produk);
			return new ResponseEntity<>("Add sukses produk id:"+produk.getId(),HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Add gagal"+produk.getId(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePut(@RequestBody Produk produk, @PathVariable Integer id){
		try {
			Produk existProduk = produkService.getProduk(id);
			produk.setId(id);
			produkService.saveProduk(produk);
			return new ResponseEntity<>("Edit produk id:"+id+" sukses",HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Edit produk id:"+id+" sagal",HttpStatus.NOT_FOUND);
		}
	}
	
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			Produk existProduk = produkService.getProduk(id);
			produkService.deleteProduk(id);
			return new ResponseEntity<>("Delete produk id:"+id+" sukses",HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Delete produk id:"+id+" gagal",HttpStatus.NOT_FOUND);
		}
		
	}
}

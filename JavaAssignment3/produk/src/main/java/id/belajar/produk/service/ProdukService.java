package id.belajar.produk.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.belajar.produk.entity.Produk;
import id.belajar.produk.repository.ProdukRepository;


@Service
@Transactional
public class ProdukService {
	@Autowired
	private ProdukRepository produkRepository;
	public List<Produk> listAllProduk(){
		return produkRepository.findAll();
	}
	public void saveProduk(Produk produk){
		produkRepository.save(produk);
	}
	public Produk getProduk(Integer id) {
		return produkRepository.findById(id).get();
	}
	public void deleteProduk(Integer id) {
		produkRepository.deleteById(id);
	}
}

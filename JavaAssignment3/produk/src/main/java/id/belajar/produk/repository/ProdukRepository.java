package id.belajar.produk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.belajar.produk.entity.Produk;

public interface ProdukRepository extends JpaRepository<Produk, Integer> {

}

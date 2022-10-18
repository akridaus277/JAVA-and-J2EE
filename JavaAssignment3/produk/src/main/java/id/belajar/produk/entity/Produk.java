package id.belajar.produk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="produk")
public class Produk {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private String nama;
	
	@Getter @Setter
	private double hargaBeli;
	
	@Getter @Setter
	private double hargaJual;
	
	public Produk() {
		
	}
	
	public Produk(int id, String nama, double hargaBeli, double hargaJual) {
		this.id = id;
		this.nama = nama;
		this.hargaBeli = hargaBeli;
		this.hargaJual = hargaJual;
	}
	


	
}


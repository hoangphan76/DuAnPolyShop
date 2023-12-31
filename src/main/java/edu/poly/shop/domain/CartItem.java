package edu.poly.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cartitems")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartiemId;
	
//	@Column(nullable = true)
//	private int productId;
	
//	private String name;
	private int quantity;
//	private double unitPrice;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product ;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer ;
}

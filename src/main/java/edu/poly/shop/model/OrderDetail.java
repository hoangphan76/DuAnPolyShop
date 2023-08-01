package edu.poly.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
	private int oderDetailId;
	private int orderId;
	private int productid;
	private int quantity;
	private double unitPrice;
}

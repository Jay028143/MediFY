package com.medify.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "description")
	private String description;

	@Column(name = "id_check")
	private double idCheck;

	@Column(name = "store_id")
	private int storeId;

	@Column(name = "available_stock")
	private int availableStock;

	@Column(name = "total_stock")
	private int totalStock;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

}

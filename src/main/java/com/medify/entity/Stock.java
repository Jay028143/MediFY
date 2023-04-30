package com.medify.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="stocks")
public class Stock {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
 
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "medicine_id")
//    @JsonIgnoreProperties("medicine")/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="medicine_id")
    @JsonIgnore
    private Medicine medicine;


	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Long getId() {
		return id;
	}	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", quantity=" + quantity + ", expiryDate=" + expiryDate + ", medicine=" + medicine
				+ "]";
	}
    
	
}

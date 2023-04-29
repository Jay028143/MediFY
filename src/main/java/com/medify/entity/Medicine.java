package com.medify.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;




/**
 * @author p028143m
 *
 */
@Table(name = "medicines")
@Entity
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_id")
	private Long medicineId;
	
	@Column(name = "medicine_code")
	private String medicineCode;

	@Column(name = "medicine_name")
	private String medicineName;

	@Column(name = "medicine_price")
	private double medicinePrice;

	@Column(name = "description")
	private String description;

	@Column(name = "id_check")
	private String idCheck;

	@Column(name = "store_id")
	private Long storeId;

	@Column(name = "available_stock")
	private Long availableStock;

	@Column(name = "total_stock")
	private Long totalStock;

	@Column(name = "user_id")
	private Long userId;
	

	@Column(name = "created_at")
	private String createdAt;

	@Column(name = "updated_at")
	private String updatedAt;
	
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "medicine", cascade = CascadeType.ALL)
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name = "medicine_id",referencedColumnName="medicine_id")
	
	private List<Stock> stock;

	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getIdCheck() {
		return idCheck;
	}

	public void setIdCheck(String idCheck) {
		this.idCheck = idCheck;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Long availableStock) {
		this.availableStock = availableStock;
	}

	public Long getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(Long totalStock) {
		this.totalStock = totalStock;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineCode=" + medicineCode + ", medicineName="
				+ medicineName + ", medicinePrice=" + medicinePrice + ", description=" + description + ", idCheck="
				+ idCheck + ", storeId=" + storeId + ", availableStock=" + availableStock + ", totalStock=" + totalStock
				+ ", userId=" + userId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", stock=" + stock
				+ ", getMedicineId()=" + getMedicineId() + ", getMedicineCode()=" + getMedicineCode()
				+ ", getMedicineName()=" + getMedicineName() + ", getMedicinePrice()=" + getMedicinePrice()
				+ ", getDescription()=" + getDescription() + ", getIdCheck()=" + getIdCheck() + ", getStoreId()="
				+ getStoreId() + ", getAvailableStock()=" + getAvailableStock() + ", getTotalStock()=" + getTotalStock()
				+ ", getUserId()=" + getUserId() + ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()="
				+ getUpdatedAt() + ", getStock()=" + getStock() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


	

	
}

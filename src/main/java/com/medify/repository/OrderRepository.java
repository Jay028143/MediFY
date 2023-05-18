package com.medify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medify.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findByStoreId(Long storeId);

	@Query(value= "SELECT SUM(IFNULL(total_price, 0)) FROM orders WHERE store_id=:storeId and created_at BETWEEN :startDate AND :endDate",nativeQuery = true )
	Long getSalesReportByStoreId(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("storeId") Long storeId);

}

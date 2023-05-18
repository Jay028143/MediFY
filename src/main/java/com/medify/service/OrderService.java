package com.medify.service;


import java.util.List;
import java.util.Map;

import com.medify.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);
	
	List<Order> fetchAllOrders();
	
	Order getOrderById(Long id);
	
	Order updateOrderById(Long id,Order order);
	
	void deleteOrderById(Long id);

	List<Order> fetchAllOrdersByStoreId(Long storeId);

	Map<?, ?> getSalesReportByStoreId(Long storeId);
}

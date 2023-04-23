package com.medify.service;


import java.util.List;

import com.medify.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);
	
	List<Order> fetchAllOrders();
	
	Order getOrderById(Long id);
	
	Order updateOrderById(Long id,Order order);
	
	void deleteOrderById(Long id);
}

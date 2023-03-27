package com.medify.service;


import java.util.List;

import com.medify.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);
	
	List<Order> fetchAllOrders();
	
	Order getOrderById(Integer id);
	
	Order updateOrderById(Integer id,Order order);
	
	void deleteOrderById(Integer id);
}

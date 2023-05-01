package com.medify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Order;
import com.medify.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> fetchAllOrders() {	
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Long id) {
		Optional<Order> order=orderRepository.findById(id);
		if(order.isPresent())
		{
			return order.get();
		}
		return null;
	}

	@Override
	public Order updateOrderById(Long id, Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrderById(Long id) {
		 orderRepository.deleteById(id);
	}

	@Override
	public List<Order> fetchAllOrdersByStoreId(Long storeId) {
		// TODO Auto-generated method stub
		return orderRepository.findByStoreId(storeId);
	}

}

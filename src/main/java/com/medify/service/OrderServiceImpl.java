package com.medify.service;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Medicine;
import com.medify.entity.Order;
import com.medify.entity.OrderDetail;
import com.medify.repository.MedicineRepository;
import com.medify.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public Order saveOrder(Order order) {
		
		List<OrderDetail>  orderDetail=order.getOrderDetail();
		
		for (OrderDetail orderDetail2 : orderDetail) {
			Optional<Medicine>  medicine=medicineRepository.findByMedicineId(orderDetail2.getMedicineId());
			if (medicine.isPresent()) {
				Medicine medicine2 = medicine.get();
				Long availableQuantity = medicine2.getAvailableStock() - orderDetail2.getQuantity();
				medicine2.setAvailableStock(availableQuantity);
				medicineRepository.save(medicine2);
			}
		}
		
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

	@Override
	public Map<?, ?> getSalesReportByStoreId(Long storeId) {
		
		Map map=new HashMap<>();
		String[] last7DayData = new String[7];
		String[] days=new String[7];
		Calendar calendar = Calendar.getInstance();
		String dayNames[] = new DateFormatSymbols().getWeekdays(); 
	    for (int i =last7DayData.length-1 ; i >= 0; i--) {
	    	Date startDate = calendar.getTime();
	    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    	String strStartDate = dateFormat.format(startDate) +" 00:00:00"; 
	        System.err.println("StartDate."+strStartDate);
	        
	        Date endDate = calendar.getTime();
	        days[i]=dayNames[calendar.get(Calendar.DAY_OF_WEEK)];
	        String streEndDate = dateFormat.format(endDate)+" 23:59:00"; 
	        System.err.println("streEndDate."+streEndDate);
	        calendar.add(Calendar.DATE, -1);
	        Long total=orderRepository.getSalesReportByStoreId(strStartDate, streEndDate, storeId);
	        String stotal=total==null?"0":coolFormat(total, 0);
	        last7DayData[i]=total==null?"0":stotal.substring(0,stotal.length()-1);
	    }
	    map.put("data", last7DayData);
	    map.put("days", days);
		return map;
	}
	private  String coolFormat(double n, int iteration) {
		  char[] c = new char[]{'k', 'm', 'b', 't'};
	    double d = ((long) n / 100) / 10.0;
	    boolean isRound = (d * 10) %10 == 0;//true if the decimal part is equal to 0 (then it's trimmed anyway)
	    return (d < 1000? //this determines the class, i.e. 'k', 'm' etc
	        ((d > 99.9 || isRound || (!isRound && d > 9.99)? //this decides whether to trim the decimals
	         (int) d * 10 / 10 : d + "" // (int) d * 10 / 10 drops the decimal
	         ) + "" + c[iteration]) 
	        : coolFormat(d, iteration+1));

	}


}

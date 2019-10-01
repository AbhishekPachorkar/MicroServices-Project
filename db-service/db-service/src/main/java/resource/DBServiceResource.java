package resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Order;
import model.Orders;
import repository.OrdersRepository;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

	private OrdersRepository ordersRepository;
	
	
	public DBServiceResource(OrdersRepository ordersRepository) {
		super();
		this.ordersRepository = ordersRepository;
	}


	@GetMapping("/{username}")
	public List<String> getOrders(@PathVariable("username") final String username)
	{
		return getOrdersByUserName(username);
	}
	
	private List<String> getOrdersByUserName(@PathVariable("username") String username)
	{
		return ordersRepository.findbyUserName(username)
				.stream()
				.map(Order::getOrder)
				.collect(Collectors.toList());
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Orders orders)
	{
		
		
		return getOrdersByUserName(orders.getUserName());
	}
	
	@PostMapping("/delete")
	public List<String> delete(@PathVariable("username") final String username)
	{
		List<Order> orders=ordersRepository.findbyUserName(username);
		
		ordersRepository.deleteAll(orders);
		return getOrdersByUserName(username); 
	}
}

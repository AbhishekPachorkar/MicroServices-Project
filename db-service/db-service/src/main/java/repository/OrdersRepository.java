package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Order;

public interface OrdersRepository extends JpaRepository<Order, Integer>{

	List<Order> findbyUserName(String username);

}

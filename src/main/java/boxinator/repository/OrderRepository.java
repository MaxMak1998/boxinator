package boxinator.repository;

import boxinator.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository {
    void insertOrder(Order order);

    List getListOfOrders();
}

package boxinator.repository;

import boxinator.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final EntityManager manager;
    private static final String insertQuery = "INSERT INTO orders (name,weight,colour,country) VALUES (?,?,?,?);";
    private static final String getQuery = "SELECT * FROM orders;";

    @Autowired
    public OrderRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void insertOrder(Order order) {
        Query query = manager.createNativeQuery(insertQuery);
        query.setParameter(1, order.getName());
        query.setParameter(2, order.getWeight());
        query.setParameter(3, order.getColour());
        query.setParameter(4, order.getCountry());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List getListOfOrders() {
        Query query = manager.createNativeQuery(getQuery);
        return query.getResultList();
    }
}

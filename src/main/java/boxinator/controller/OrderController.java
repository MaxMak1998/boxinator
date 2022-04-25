package boxinator.controller;

import boxinator.model.Order;
import boxinator.repository.OrderRepository;
import boxinator.service.OrderValidator;
import boxinator.view.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderValidator orderValidator) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
    }

    @RequestMapping(value = "/new-order", method = RequestMethod.POST)
    public ResponseEntity<?> placeAnOrder(@RequestBody OrderForm orderForm) {
        Order order = createOrder(orderForm);
        String response = orderValidator.validate(orderForm);
        if (response.equals("OK")) {
            orderRepository.insertOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @RequestMapping(value = "/all-orders", method = RequestMethod.GET)
    public List<?> getAllOrders() {
        return orderRepository.getListOfOrders();
    }

    public Order createOrder(OrderForm orderForm) {
        return new Order(
                orderForm.getName(),
                orderForm.getWeight(),
                orderForm.getColour(),
                orderForm.getCountry()
        );
    }
}

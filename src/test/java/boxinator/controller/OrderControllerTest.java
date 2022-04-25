package boxinator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import boxinator.service.OrderValidatorImpl;
import boxinator.view.OrderForm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderControllerTest {
    OrderValidatorImpl orderValidator = new OrderValidatorImpl();

    @Test
    void createOrderTestPass() {
        OrderForm orderForm = new OrderForm(
                "John",
                2,
                "#0008ff",
                "sweden"
        );
        assertEquals("OK", orderValidator.validate(orderForm));
    }

    @Test
    void createOrderTestFailName() {
        OrderForm orderForm = new OrderForm(
                "",
                2,
                "#0008ff",
                "sweden"
        );
        assertEquals("Name Cannot Be Empty!", orderValidator.validate(orderForm));
    }

    @Test
    void createOrderTestFailWeight() {
        OrderForm orderForm = new OrderForm(
                "Marcus",
                -2,
                "#0008ff",
                "sweden"
        );
        assertEquals("Weight Must Be Greater Than 0!", orderValidator.validate(orderForm));
    }

    @Test
    void createOrderTestFailCountry() {
        OrderForm orderForm = new OrderForm(
                "John",
                2,
                "#0008ff",
                "usa"
        );
        assertEquals("Invalid Country Selected!", orderValidator.validate(orderForm));
    }

    @Test
    void createOrderTestFailColour() {
        OrderForm orderForm = new OrderForm(
                "Bob",
                2,
                "",
                "sweden"
        );
        assertEquals("Colour Cannot Be Empty!", orderValidator.validate(orderForm));
    }
}

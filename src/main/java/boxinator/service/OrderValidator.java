package boxinator.service;

import boxinator.view.OrderForm;
import net.minidev.json.JSONObject;

public interface OrderValidator {
    String validate(OrderForm orderForm);
    boolean validCountry(String country);
}

package boxinator.service;

import boxinator.view.OrderForm;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class OrderValidatorImpl implements OrderValidator {
    @Override
    public String validate(OrderForm orderForm) {
        if (Strings.isBlank(orderForm.getName())) {
            return "Name Cannot Be Empty!";
        }
        if (!validCountry(orderForm.getCountry())) {
            return "Invalid Country Selected!";
        }
        if (Strings.isBlank(orderForm.getColour())) {
            return "Colour Cannot Be Empty!";
        }
        if (orderForm.getWeight() <= 0) {
            return "Weight Must Be Greater Than 0!";
        }
        return "OK";
    }

    @Override
    public boolean validCountry(String country) {
        if (country.equals("sweden")) {
            return true;
        }
        if (country.equals("china")) {
            return true;
        }
        if (country.equals("brazil")) {
            return true;
        }
        if (country.equals("australia")) {
            return true;
        }
        return false;
    }
}

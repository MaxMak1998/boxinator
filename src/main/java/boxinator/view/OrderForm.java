package boxinator.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
@Data
@AllArgsConstructor
public class OrderForm {
    private String name;
    private double weight;
    private String colour;
    private String country;
}

package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import org.springframework.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Blazej on 20.05.2017.
 */
@Component
public class UnitsInStockValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if (product.getUnitPrice() != null && new BigDecimal(10000)
                .compareTo(product.getUnitPrice()) <= 0 && product.getUnitsInStock() > 99) {
            errors.rejectValue("unitsInStock", "com.packt.webstore.validator.UnitsInStockValidator.message");
        }
    }

}
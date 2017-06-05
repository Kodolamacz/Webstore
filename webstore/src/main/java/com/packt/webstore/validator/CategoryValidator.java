package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

/**
 * Created by Blazej on 21.05.2017.
 */
@Component
public class CategoryValidator implements ConstraintValidator<Category,String> {

    @Autowired
    private ProductService productService;

    private ArrayList<String> allowedCategories;

    private String []catNames;
    public CategoryValidator(){
        allowedCategories = new ArrayList<String>();

        catNames = new String[]{"Telefon","Tablet","Laptop","Zasilacz"};

        for (String cat: catNames) {
            allowedCategories.add(cat);
        }
    }

    public void initialize(Category constraintAnnotation){

    }
    public boolean isValid(String value, ConstraintValidatorContext context){

        if(allowedCategories.contains(value.trim())){
            return true;
        }
        return false;
    }
}

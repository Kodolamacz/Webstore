package com.packt.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Blazej on 13.04.2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak produktow we wskazanej kategorii")
public class NoProductsFoundUnderCategoryException extends RuntimeException {
    private static final long serialVersionUID = 3935230281455340039L;
}

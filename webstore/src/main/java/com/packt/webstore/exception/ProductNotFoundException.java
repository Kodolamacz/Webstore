package com.packt.webstore.exception;

/**
 * Created by Blazej on 20.04.2017.
 */
public class ProductNotFoundException extends RuntimeException {
    private static long serialVersionUID = -694354952032299587L;
    private String productId;
    public ProductNotFoundException(String productId){
        this.productId = productId;
    }
    public String getProductId(){
        return productId;
    }
}

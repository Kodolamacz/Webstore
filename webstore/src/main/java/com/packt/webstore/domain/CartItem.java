package com.packt.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * Created by Blazej on 21.05.2017.
 */
public class CartItem implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5214821943660363901L;
	private Product product;
    private int quantity;
    private BigDecimal totalPrice;
    public CartItem(Product product){
        super();
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getUnitPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void updateTotalPrice() {
      totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        return product != null ? product.equals(cartItem.product) : cartItem.product == null;
    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }
}

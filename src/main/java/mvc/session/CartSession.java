package mvc.session;

import javax.persistence.Column;

public class CartSession {
    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private int quantity;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

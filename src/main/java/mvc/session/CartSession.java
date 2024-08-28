package mvc.session;

import mvc.entity.Product;

public class CartSession {
    private Product product;
    private int quantity;

    // Constructor
    public CartSession(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getter và Setter
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

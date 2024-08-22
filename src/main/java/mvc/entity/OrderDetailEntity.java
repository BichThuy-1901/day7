package mvc.entity;

import javax.persistence.*;

@Entity
@Table (name = "orderDetails")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitPrice")
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity orders;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;

    public OrderDetailEntity() {
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderEntity getOrders() {
        return orders;
    }

    public void setOrders(OrderEntity orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", orders=" + orders +
                '}';
    }
}

package mvc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="orderDate")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate orderDate;

    @Column(name="customerName")
    private String customerName;

    @Column(name="customerAddress")
    private String customerAddress;

    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetailList;

    public Order(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<OrderDetails> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetails> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}

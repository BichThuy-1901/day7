package mvc.controller;

import mvc.configuration.JPAConfig;
import mvc.entity.OrderDetailEntity;
import mvc.entity.OrderEntity;
import mvc.entity.ProductEntity;
import mvc.repository.OrderDetailRepository;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
    static ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");

    public static void main(String[] args) {
//        createOrder();
//
    }

    public static void createOrder() {
        // Tạo sản phẩm
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("pen");
        productEntity.setPrice(2000);

        // Lưu sản phẩm vào CSDL trước
        S save = productRepository.save(productEntity);

        // Tạo chi tiết đơn hàng
        OrderDetailEntity orderDetailEntity1 = new OrderDetailEntity();
        orderDetailEntity1.setQuantity(5);
        orderDetailEntity1.setUnitPrice(2000);
        orderDetailEntity1.setProductName("pen");
        orderDetailEntity1.setProduct(productEntity); // Liên kết với sản phẩm

        List<OrderDetailEntity> orderDetails = new ArrayList<>();
        orderDetails.add(orderDetailEntity1);

        // Tạo đơn hàng
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(LocalDate.parse("2024-08-17"));
        orderEntity.setCustomerName("Bich Thuy");
        orderEntity.setCustomerAddress("Hoi An");
        orderEntity.setOrdersDetailsEntities(orderDetails);
        orderDetailEntity1.setOrders(orderEntity); // Liên kết với đơn hàng

        // Lưu đơn hàng cùng với chi tiết đơn hàng
        orderRepository.save(orderEntity);
    }
}

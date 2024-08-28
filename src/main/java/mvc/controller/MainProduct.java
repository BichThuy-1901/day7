//package mvc.controller;
//
//import mvc.configuration.JPAConfig;
//import mvc.entity.ProductEntity;
//import mvc.repository.OrderDetailRepository;
//import mvc.repository.OrderRepository;
//import mvc.repository.ProductRepository;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainProduct {
//    public class ProductController {
//        static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
//        static ProductRepository productRepository = context.getBean(ProductRepository.class);
//        static OrderRepository orderRepository = context.getBean(OrderRepository.class);
//        static OrderDetailRepository orderDetailRepository = context.getBean(OrderDetailRepository.class); // Thêm repository cho OrderDetail
//
//        public static void main(String[] args) {
//            createOrder();
//        }
//
//        public static void createOrder() {
//            // Tạo và lưu sản phẩm
//            List<ProductEntity> products = new ArrayList<>();
//            products.add(new ProductEntity("Pen", 2000));
//            products.add(new ProductEntity("Notebook", 5000));
//            products.add(new ProductEntity("Pencil", 1000));
//            products.add(new ProductEntity("Eraser", 500));
//            products.add(new ProductEntity("Ruler", 3000));
//
//            for (ProductEntity product : products) {
//                productRepository.save(product);
//            }
//        }
//    }
//}

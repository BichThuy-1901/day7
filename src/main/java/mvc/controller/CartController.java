package mvc.controller;

import mvc.entity.Order;
import mvc.entity.OrderDetails;
import mvc.entity.Product;
import mvc.repository.OrderDetailRepository;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import mvc.session.CartSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @RequestMapping(value = "/addToCart/{id}")
    public String addItem(@PathVariable int id, HttpSession session, Model model) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new ArrayList<>();
            session.setAttribute("cartList", cartList);
        }

        Product product = productRepository.findById(id).get();
        if (product != null) {
            boolean itemExists = false;
            for (CartSession item : cartList) {
                if (item.getProduct().getId() == id) {
                    item.setProduct(product);
                    item.setQuantity(item.getQuantity() + 1);
                    itemExists = true;
                    break;
                }
            }
            if (!itemExists) {
                cartList.add(new CartSession(product, 1));
            }
        }
        session.setAttribute("cartList", cartList);
        model.addAttribute("cartList", cartList);
        return "shoppingcart/cart";
    }

    @RequestMapping(value = "/removeItem/{id}")
    public String removeItem(@PathVariable int id, HttpSession session) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
        if (cartList != null) {
            cartList.removeIf(item -> item.getProduct().getId() == id);
        }
        return "shoppingcart/cart";
    }

    @RequestMapping(value = "/cart")
    public String showCart(Model model, HttpServletRequest request) {
        List<CartSession> cartList = (List<CartSession>) request.getSession().getAttribute("cartList");
        model.addAttribute("cartList", cartList);
        return "shoppingcart/cart";
    }

    @RequestMapping(value = "/checkout")
    public String showCheckOutForm(Model model, HttpSession session) {
        model.addAttribute("orderList", new Order());
        return "shoppingcart/checkout";
    }

    @RequestMapping(value = "/placeOrder")
    public String placeOrder(Order order, HttpSession session) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");

        order.setOrderDate(LocalDate.now());
        orderRepository.save(order);

        for (CartSession item : cartList) {
            OrderDetails orderDetail = new OrderDetails();
            orderDetail.setProduct(item.getProduct());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setOrder(order);
            orderDetailRepository.save(orderDetail);
        }

        // Clear the cart
        session.removeAttribute("cartList");

        return "redirect:/order";
    }

    @RequestMapping(value = "/order")
    public String showOrders(Model model, HttpServletRequest request) {
        List<Order> orderList = (List<Order>) orderRepository.findAll();
        model.addAttribute("orderList", orderList);
        return "shoppingcart/order";
    }

    @RequestMapping(value = "/orderDetail/{id}", method = GET)
    public String showOrderDetailsByOrderId(Model model, @PathVariable int id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            List<OrderDetails> orderDetails = order.getOrderDetailList();
            model.addAttribute("orderDetails", orderDetails);
            model.addAttribute("orderId", id);
        }
        return "shoppingcart/orderDetail";
    }
}
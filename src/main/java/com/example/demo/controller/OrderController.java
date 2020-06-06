package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @GetMapping("/list")
    public String getOrders(Model model,
                            @RequestParam("page")Optional<Integer> page){
        int currentPage = page.orElse(1);
        Page<Order> orderPage = orderService.getAllOrdersPaginated(PageRequest.of(currentPage -1, 10));
        model.addAttribute("orderPage", orderPage);
        int totalPages = orderPage.getTotalPages();
        if (totalPages >0) {
            List<Integer> pageNumbers = new ArrayList<>();
            for (int i = 1; i <= totalPages; i++) {
                pageNumbers.add(i);
            }
            /*List<Integer> streamPages = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());*/
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "orders";
    }
}

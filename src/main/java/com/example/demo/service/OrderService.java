package com.example.demo.service;

import com.example.demo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    Page<Order> getAllOrdersPaginated(Pageable pageable);

}

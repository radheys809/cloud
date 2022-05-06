package io.cloud.order.service;

import io.cloud.order.dto.TransactionRequest;
import io.cloud.order.model.Order;
import io.cloud.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Mono<Order> createOrder(TransactionRequest transactionRequest) {
        return orderRepository.save(transactionRequest.getOrder());

    }
}

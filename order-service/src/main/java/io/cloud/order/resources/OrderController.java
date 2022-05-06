package io.cloud.order.resources;

import io.cloud.order.dto.TransactionRequest;
import io.cloud.order.service.OrderService;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OrderController {

    private final OrderService orderService;
    private final ResourceLoader
            resourceLoader;

    public OrderController(OrderService orderService, ResourceLoader resourceLoader) {
        this.orderService = orderService;
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("createOrder")
    public ResponseEntity<Object> creteOrder(@RequestBody TransactionRequest transactionRequest) {

        return ResponseEntity.ok(orderService.createOrder(transactionRequest));
    }

    @GetMapping("path")
    public String test() throws IOException {
        return resourceLoader.getResource("classpath").getURL().getPath();
    }
}

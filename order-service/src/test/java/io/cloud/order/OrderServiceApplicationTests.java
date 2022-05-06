package io.cloud.order;

import io.cloud.order.dto.Payment;
import io.cloud.order.dto.TransactionRequest;
import io.cloud.order.model.Order;
import io.cloud.order.model.Status;
import io.cloud.order.repository.OrderRepository;
import io.cloud.order.resources.OrderController;
import io.cloud.order.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springdoc.core.SpringDocConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
@EnableAutoConfiguration(exclude = SpringDocConfiguration.class)
@ActiveProfiles("tests")
class OrderServiceApplicationTests {
    @Autowired
    OrderService orderService;

    @MockBean
    OrderRepository orderRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);


    }
    @Test
    void contextLoads() {
    }

    @Test
    final void createOrderThenSuccessTest() {

        Order order =new Order();
        order.setOrderId("1284994");
        order.setOrderStatus(Status.PENDING);
        Mono<Order> orderMono= Mono.just(order);
        when(orderRepository.save(new Order())).thenReturn(orderMono);
        Mono<Order> returnedValue=orderService.createOrder(new TransactionRequest(new Order(),new Payment()));
      System.out.println(returnedValue.block());
        Assertions.assertThat(returnedValue)
                .isEqualTo(orderMono);

    }
}

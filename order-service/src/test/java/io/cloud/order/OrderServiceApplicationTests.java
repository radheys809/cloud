package io.cloud.order;

import io.cloud.order.dto.Payment;
import io.cloud.order.dto.TransactionRequest;
import io.cloud.order.model.Order;
import io.cloud.order.model.Status;
import io.cloud.order.repository.OrderRepository;
import io.cloud.order.service.OrderService;
import io.cloud.order.utils.UtilityClass;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springdoc.core.SpringDocConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
@EnableAutoConfiguration(exclude = SpringDocConfiguration.class)
@ActiveProfiles("tests")
class OrderServiceApplicationTests {
    @Autowired
    OrderService orderService;

    @MockBean
    OrderRepository orderRepository;
    UtilityClass utilityClass1 = new UtilityClass();


    @Test
    void contextLoads() {
    }

    @Test
    final void createOrderThenSuccessTest() {

        Order order = new Order();
        order.setOrderId("1284994");
        order.setOrderStatus(Status.PENDING);
        Mono<Order> orderMono = Mono.just(order);
        when(orderRepository.save(new Order())).thenReturn(orderMono);
        Mono<Order> returnedValue = orderService.createOrder(new TransactionRequest(new Order(), new Payment()));
        System.out.println(returnedValue.block());
        assertThat(returnedValue)
                .isEqualTo(orderMono);
    }

    @Test
    final void testStaticMethodsMock() {
        try (MockedStatic<UtilityClass> utilityClassMock = Mockito.mockStatic(
                UtilityClass.class
        )) {
            utilityClass1.setClassName("Test");
            utilityClass1.setAuthor("Radhey");
            utilityClassMock.when((MockedStatic.Verification) UtilityClass.getInstance()).thenReturn(utilityClass1);
            assertThat(UtilityClass.getInstance()).isEqualTo(utilityClass1);

        }
    }
    @Test
    final void becameCoder() {
        try {
            while (true) {
                learn();
                eat();
                sleep(8);
                repeat();
            }
        } catch (NullPointerException npe) {
            fail("Yes You are a coder, but need some improvement");
        } catch (Exception e) {
            System.err.println("No you are not! but you can be");
        }
    }

    private void sleep(int hours) throws InterruptedException {
        Thread.sleep(hours);
    }

    private void repeat() {
    }

    private void eat() {

    }

    private void learn() {
    }
}

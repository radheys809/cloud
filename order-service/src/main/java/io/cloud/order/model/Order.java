package io.cloud.order.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("order")
@Data
public class Order implements Serializable {

    private String orderId;
    private Status orderStatus;

}

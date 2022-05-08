package io.cloud.order.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UtilityClass {

    private String className;
    private String author;
     public static UtilityClass getInstance() {
         System.out.println(UtilityClass.class);
        return new UtilityClass();
    }
}

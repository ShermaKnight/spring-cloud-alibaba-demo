package org.example.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderResponse {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;
    private String createTime;
    private String updateTime;
}

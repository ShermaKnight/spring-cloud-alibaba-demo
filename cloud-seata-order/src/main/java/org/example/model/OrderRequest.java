package org.example.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderRequest {

    @NotNull(message = "产品ID不能为空")
    private Long productId;

    @Min(value = 1, message = "产品数量最小是1")
    private Integer count = 1;
}

package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage implements Serializable {

    private Long id;
    private Long productId;
    private BigDecimal price;
    private Long total;
    private Long used;
    private Long residue;
}

package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    private Long id;
    private Long userId;
    private String userName;
    private String nickName;
    private String address;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
    private Date createTime;
    private Date updateTime;
}

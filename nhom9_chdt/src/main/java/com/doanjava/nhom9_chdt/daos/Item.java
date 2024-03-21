package com.doanjava.nhom9_chdt.daos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long dienthoaiId;
    private String dienthoaiName;
    private String hinh;
    private Double price;
    private int quantity;
}

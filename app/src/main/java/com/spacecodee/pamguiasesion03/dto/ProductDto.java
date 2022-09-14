package com.spacecodee.pamguiasesion03.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {

    private int brand;
    private int tall;
    private int pairs;
    private int price;
    private int sale;
    private double discount;
    private double netSale;
}

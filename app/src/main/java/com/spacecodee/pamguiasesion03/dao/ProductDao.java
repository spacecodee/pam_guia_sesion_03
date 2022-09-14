package com.spacecodee.pamguiasesion03.dao;

import com.spacecodee.pamguiasesion03.dto.ProductDto;

public class ProductDao {

    public String calcularOperacion(ProductDto productDto) {
        productDto.setPrice(this.calcularCostoParZapatillas(productDto));
        productDto.setSale(this.calcularVenta(productDto));
        productDto.setDiscount(this.calcularDescuento(productDto));
        productDto.setNetSale(this.calcularVentaNeta(productDto));
        //message get all
        return "El costo del par de zapatillas es: " + productDto.getPrice()
                + "\nLa venta de la Zapatilla es: " + productDto.getSale()
                + "\nEl descuento es: " + productDto.getDiscount()
                + "\nLa venta neta es: " + productDto.getNetSale();
    }

    private int calcularCostoParZapatillas(ProductDto productDto) {
        int cost = 0;
        switch (productDto.getBrand()) {
            case 0:
                switch (productDto.getTall()) {
                    case 0:
                        cost = 150;
                        break;
                    case 1:
                    case 2:
                        cost = 160;
                        break;
                }
                break;
            case 1:
                switch (productDto.getTall()) {
                    case 0:
                        cost = 140;
                        break;
                    case 1:
                    case 2:
                        cost = 150;
                        break;
                }
                break;
            case 2:
                switch (productDto.getTall()) {
                    case 0:
                        cost = 80;
                        break;
                    case 1:
                        cost = 85;
                        break;
                    case 2:
                        cost = 90;
                        break;
                }
                break;
        }
        return cost;
    }

    private int calcularVenta(ProductDto productDto) {
        return productDto.getPrice() * productDto.getPairs();
    }

    private double calcularDescuento(ProductDto productDto) {
        double discount = 0;

        if (productDto.getPairs() > 1 && productDto.getPairs() < 6) {
            discount = 0.05 * productDto.getSale();
        }
        else if (productDto.getPairs() > 5 && productDto.getPairs() < 11) {
            discount = 0.08 * productDto.getSale();
        }
        else if (productDto.getPairs() > 10 && productDto.getPairs() < 21) {
            discount = 0.1 * productDto.getSale();
        }
        else if (productDto.getPairs() > 19) {
            discount = 0.15 * productDto.getSale();
        }
        return discount;
    }

    private double calcularVentaNeta(ProductDto productDto) {
        return productDto.getSale() - productDto.getDiscount();
    }
}

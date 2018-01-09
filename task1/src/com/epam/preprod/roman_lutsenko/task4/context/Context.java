package com.epam.preprod.roman_lutsenko.task4.context;

import com.epam.preprod.roman_lutsenko.task4.services.CartService;
import com.epam.preprod.roman_lutsenko.task4.services.FileSavable;
import com.epam.preprod.roman_lutsenko.task4.services.OrderService;
import com.epam.preprod.roman_lutsenko.task4.services.ProductService;

import java.util.ResourceBundle;

/**
 * Wrapper to unite service.
 */
public class Context {

    private ProductService localProductService;
    private CartService localCartService;
    private OrderService localOrderService;
    private StrategyContext strategyContext;
    private ResourceBundle resourceBundle;

    public Context(ProductService localProductService, CartService localCartService, OrderService localOrderService, StrategyContext strategyContext, ResourceBundle resourceBundle) {
        this.localProductService = localProductService;
        this.localCartService = localCartService;
        this.localOrderService = localOrderService;
        this.strategyContext = strategyContext;
        this.resourceBundle = resourceBundle;
        ((FileSavable)getLocalProductService()).unSerializeProduct();
    }

    public ProductService getLocalProductService() {
        return localProductService;
    }

    public CartService getLocalCartService() {
        return localCartService;
    }

    public OrderService getLocalOrderService() {
        return localOrderService;
    }

    public StrategyContext getStrategyContext() {
        return strategyContext;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

}
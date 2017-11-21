package com.epam.preprod.roman_lutsenko.task4.context;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;
import com.epam.preprod.roman_lutsenko.task4.constants.StrategyContainer;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalAllCartAddingDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalCartDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalOrderDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalAllCartAddingService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalCartService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalOrderService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalProductService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.AllCartAddingService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.CartService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.OrderService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.ProductService;
import com.epam.preprod.roman_lutsenko.task4.services.CartService;
import com.epam.preprod.roman_lutsenko.task4.services.OrderService;
import com.epam.preprod.roman_lutsenko.task4.services.ProductService;

/**
 * Wrapper to unite services.
 */
public class Context {

    private ProductService localProductService;
    private CartService localCartService;
    private OrderService localOrderService;
    private StrategyContext strategyContext;
    //context with strategy
    // контекст на мапе оформить

    public Context(ProductService localProductService, CartService localCartService, OrderService localOrderService) {
        this.localProductService = localProductService;
        this.localCartService = localCartService;
        this.localOrderService = localOrderService;
        getLocalProductService().unSerializeProduct();
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

    public void setStrategyContext(StrategyContext strategyContext) {
        this.strategyContext = strategyContext;
    }
}

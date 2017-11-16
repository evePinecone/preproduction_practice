package com.epam.preprod.roman_lutsenko.task4.context;

import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;
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

public class Context {

    private ProductService localProductService;
    private CartService localCartService;
    private AllCartAddingService localAllCartAddingService;
    private OrderService localOrderService;
    private InputStrategy inputStrategy;

    @Deprecated
    public Context() {
        localProductService = new LocalProductService(new LocalProductDAO());
        localCartService = new LocalCartService(new LocalCartDAO());
        localAllCartAddingService = new LocalAllCartAddingService(new LocalAllCartAddingDAO());
        localOrderService = new LocalOrderService(new LocalOrderDAO());
    }

    public Context(ProductService localProductService, CartService localCartService, AllCartAddingService localAllCartAddingService, OrderService localOrderService) {
        this.localProductService = localProductService;
        this.localCartService = localCartService;
        this.localAllCartAddingService = localAllCartAddingService;
        this.localOrderService = localOrderService;
        getLocalProductService().unSerializeProduct();
    }

    public ProductService getLocalProductService() {
        return localProductService;
    }

    public void setLocalProductService(ProductService localProductService) {
        this.localProductService = localProductService;
    }

    public CartService getLocalCartService() {
        return localCartService;
    }

    public void setLocalCartService(CartService localCartService) {
        this.localCartService = localCartService;
    }

    public AllCartAddingService getLocalAllCartAddingService() {
        return localAllCartAddingService;
    }

    public void setLocalAllCartAddingService(AllCartAddingService localAllCartAddingService) {
        this.localAllCartAddingService = localAllCartAddingService;
    }

    public OrderService getLocalOrderService() {
        return localOrderService;
    }

    public void setLocalOrderService(OrderService localOrderService) {
        this.localOrderService = localOrderService;
    }

    public InputStrategy getInputStrategy() {
        return inputStrategy;
    }

    public void setInputStrategy(InputStrategy inputStrategy) {
        this.inputStrategy = inputStrategy;
    }

}

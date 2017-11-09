package com.epam.preprod.roman_lutsenko.task4.context;

import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalAllCartAddingDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalCartDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalAllCartAddingService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalCartService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalProductService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.AllCartAddingService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.CartService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.ProductService;

public class Context {

    private ProductService localProductService;
    private CartService localCartService;
    private AllCartAddingService localAllCartAddingService;

    public Context() {
        localProductService = new LocalProductService(new LocalProductDAO());
        localCartService = new LocalCartService(new LocalCartDAO());
        localAllCartAddingService = new LocalAllCartAddingService(new LocalAllCartAddingDAO());
    }

    public Context(LocalProductService localProductService, LocalCartService localCartService,
                   LocalAllCartAddingService localAllCartAddingService) {
        this.localProductService = localProductService;
        this.localCartService = localCartService;
        this.localAllCartAddingService = localAllCartAddingService;
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

}

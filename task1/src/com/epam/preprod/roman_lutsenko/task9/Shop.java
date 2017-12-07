package com.epam.preprod.roman_lutsenko.task9;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.context.StrategyContext;
import com.epam.preprod.roman_lutsenko.task4.controller.MenuController;
import com.epam.preprod.roman_lutsenko.task4.controller.StrategyController;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalCartDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalOrderDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalCartService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalOrderService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalProductService;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Shop implements Runnable{

    private Context context;
    private SimpleTcpServer simpleTcpServer;


    @Override
    public void run() { // я не умею пользоваться дебагером)
        initContext(context);
        initServer(context);
    }

    private void initContext(Context context) {
        LocalProductDAO localProductDAO = new LocalProductDAO(fill());
        LocalCartDAO localCartDAO = new LocalCartDAO();
        LocalOrderDAO localOrderDAO = new LocalOrderDAO();
        StrategyController strategyController = new StrategyController(); //эм, краш?
        ResourceBundle resourceBundle = getResourceBundle();

        LocalProductService localProductService = new LocalProductService(localProductDAO);
        LocalCartService localCartService = new LocalCartService(localCartDAO);
        LocalOrderService localOrderService = new LocalOrderService(localOrderDAO);
        StrategyContext strategyContext = strategyController.getStrategyContext();
        this.context = context = new Context(localProductService, localCartService, localOrderService, strategyContext, resourceBundle);
    }

    public void initServer(Context context) {
        try {
            int i = 0;
            ServerSocket server = new ServerSocket(3000);
            // this.simpleTcpServer = ;
            Thread thread = new  SimpleTcpServer(context, server);
            thread.start(); //крашится тут дальше внутри
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException in Shop#initServer" + e);
        } catch (IOException e) {
            System.out.println("IOException in Shop#initServer" + e);
        }

    }

    private static ResourceBundle getResourceBundle(){
        System.out.println("Enter locale");
        String localeString = InputUtil.stringValidationInput();
        return ResourceBundle.getBundle("resources\\ThingsLocalisation", new Locale(localeString));
    }

    private static Map<Integer, Thing> fill() {
        Laptop laptop;
        Map<Integer, Thing> productList = new HashMap<>();
        for (int index = 1; index < 6; index++) {
            laptop = new Laptop();
            laptop.setId(index);
            laptop.setPrice(index * 100);
            laptop.setNameModel("laptop" + index);
            productList.put(laptop.getId(), laptop);
        }
        return productList;
    }
}
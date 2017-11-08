package com.epam.preprod.roman_lutsenko.task4.context;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalCartDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalCartService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalProductService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Context {
    private LocalProductService localProductService;
    private LocalCartService localCartService;

    public Context() {
        localProductService = new LocalProductService(new LocalProductDAO());
        localCartService = new LocalCartService(new LocalCartDAO());
    }

    public List getAllItemsFromLocalProductService() {
        return localProductService.getAllItemsFromLocalProduct();
    }

    public void setAllItemsToLocalProductService(List<Thing> thingList) {
        localProductService.setAllItemsToLocalProduct(thingList);
    }

    public void addLocalProductService(Thing thing) {
        localProductService.addLocalProduct(thing);
    }

    public Thing getLocalProductService(int thingId) {
        return localProductService.getLocalProduct(thingId);
    }

    public void setLocalProductService(int index, Thing thing) {
        localProductService.setLocalProduct(index, thing);
    }

    public Thing removeLocalProductService(int index) {
        return localProductService.removeLocalProduct(index);
    }

    public boolean removeLocalProductService(Object object) {
        return localProductService.removeLocalProduct(object);
    }

    public void clearLocalProductService() {
        localProductService.clearLocalProduct();
    }

    public void showLocalProductService() {
        localProductService.showLocalProduct();
    }

    public void showLocalCartService() {
        Map<Integer, Integer> map = localCartService.getAllLocalCartService();
        if (map.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(getLocalProductService((int) entry.getKey()) + " | pcs:"
                        + entry.getValue());
            }
        }
    }

    public void addLocalCartService() {
        System.out.println("Enter id Thing to add to cart");
        showLocalProductService();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if(!string.equals("back")) {
            localCartService.addLocalCartService(Integer.parseInt(string));
        }
    }

    public void byAllItemsInCartLocalCartService() {
        Map<Integer, Integer> map = localCartService.getAllLocalCartService();
        if (map.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            long totalPrice = 0;
            for(Map.Entry entry : map.entrySet()) {
                totalPrice += getLocalProductService((int)entry.getKey()).getPrice() * (int)entry.getValue();
            }
            System.out.println("Total price :" + totalPrice);
        }

    }

    public void showMenu() {
        System.out.println("\t1. Show all items");
        System.out.println("\t2. Add item to cart");
        System.out.println("\t3. Show the cart");
        System.out.println("\t4. By all items in cart.(Show total price order)");
        System.out.println("\t5. Show information about last five items in cart");
        System.out.println("\texit. End of program.");
    }
}

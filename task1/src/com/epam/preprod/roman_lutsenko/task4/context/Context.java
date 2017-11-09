package com.epam.preprod.roman_lutsenko.task4.context;

import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalAllCartAddingDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalCartDAO;
import com.epam.preprod.roman_lutsenko.task4.dao.impl.LocalProductDAO;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.AllCartAddingService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.CartService;
import com.epam.preprod.roman_lutsenko.task4.services.inerfaces.ProductService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalAllCartAddingService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalCartService;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalProductService;

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

    /*  // PRODUCT SERVICE
    public List getAllItemsFromLocalProductService() {
        return localProductService.getAllItems();
    }

    public void setAllItemsToLocalProductService(List<Thing> thingList) {
        localProductService.setAllItems(thingList);
    }

    public void addLocalProductService(Thing thing) {
        localProductService.add(thing);
    }

    *//**
     * Return Thing with id = thingId.
     *
     * @param thingId
     * @return Thing element with Id = thingId. Or null if no element.
     *//*
    public Thing getLocalProductService(int thingId) {
        return localProductService.get(thingId);
    }

    public void setLocalProductService(int index, Thing thing) {
        localProductService.set(index, thing);
    }

    public Thing removeLocalProductService(int index) {
        return localProductService.remove(index);
    }

    public boolean removeLocalProductService(Object object) {
        return localProductService.remove(object);
    }

    public void clearLocalProductService() {
        localProductService.clear();
    }

    public void showLocalProductService() {
        localProductService.show();
    }

    // CART SERVICE
    @Deprecated
    public void showLocalCartService() {
        Map<Integer, Integer> map = getAllLocalCartService();
        if (map.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(getLocalProductService((int) entry.getKey()) + " | pcs:"
                        + entry.getValue());
            }
        }
    }

    public Map<Integer, Integer> getAllLocalCartService() {
        return localCartService.getAllLocalCartService();
    }

    *//**
     * Adding a thing to the cart by it id.
     *//*
    public void add(int thingId) {
        localCartService.add(thingId);
    }

    *//**
     * @return total price of orders in cart,
     *//*
    @Deprecated
    public long byAllItemsInCartLocalCartService() {
        Map<Integer, Integer> map = getAllLocalCartService();
        long totalPrice = -1;
        if (!map.isEmpty()) {
            totalPrice = 0;
            // System.out.println("Cart is empty");
            for (Map.Entry entry : map.entrySet()) {
                totalPrice += getLocalProductService((int) entry.getKey()).getPrice() * (int) entry.getValue();
            }
        }
        //   System.out.println("Total price :" + totalPrice);
        return totalPrice;
    }

    *//**
     * @param thingId
     * @return Counter of product with thingId in cart
     * or -1 if there is no such product in cart.
     *//*
    public int getCounterProduct(int thingId) {
        return localCartService.getCounterProduct(thingId);
    }

    *//**
     * Clear cart.
     *//*
    public void clear() {
        localCartService.clear();
    }

    *//**
     * Removes one element with id = thingId from cart.
     * @param thingId id
     * @return true if elemetnt removed.
     *//*
    public boolean removeLocalChartService(int thingId) {
        localCartService.remove(thingId);
    }
    // ALL CART ADDING SERVICE

    *//**
     * Add an element to Cart on position that equals its Id field.
     * Calculate all addings Cart.
     *
     * @param thingId id of adding element
     *//*
    public void addLocalAllCartAddingService(int thingId) {
        localAllCartAddingService.add(thingId);
    }

    public Map<Integer, Integer> getLocalAllCartAddingService() {
        return localAllCartAddingService.getAllCartAdding();
    }

    public void clearLocalAllCartAddingService() {
        localAllCartAddingService.clear();
    }

    *//**
     * Return thingId of element in indexInCartItemsMap position in LocalAllCartAddingDAO map.
     *
     * @param indexInCartItemsMap index of needed element
     * @return thingId of element in indexInCartItemsMap position in LocalAllCartAddingDAO map.
     *//*
    public int getThingIdByIndexInAllCartAddingItemsMap(int indexInCartItemsMap) {
        return localAllCartAddingService.getThingIdByIndexInCartItemsMap(indexInCartItemsMap);
    }

    public int sizeAllCartAddingService() {
        return localAllCartAddingService.size();
    }

    public boolean isEmpty() {
        return localAllCartAddingService.isEmpty();
    }
*/
}

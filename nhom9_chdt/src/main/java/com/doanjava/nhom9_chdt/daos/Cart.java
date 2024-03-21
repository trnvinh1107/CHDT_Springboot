package com.doanjava.nhom9_chdt.daos;


import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Cart {
    private List<Item> cartItems = new ArrayList<>();
    public void addItems(Item item) {
        boolean isExist = cartItems.stream()
                .filter(i -> Objects.equals(i.getDienthoaiId(),
                        item.getDienthoaiId()))
                .findFirst()
                .map(i -> {
                    i.setQuantity(i.getQuantity() +
                            item.getQuantity());
                    return true;
                })
                .orElse(false);
        if (!isExist) {
            cartItems.add(item);
        }
    }
    public void removeItems(Long dienthoaiId) {
        cartItems.removeIf(item -> Objects.equals(item.getDienthoaiId(),
                dienthoaiId));
    }
    public void updateItem(Long dienthoaiId, int quantity) {
        for (Item item : cartItems) {
            if (item != null) {
                if (quantity <= 0) {
                    this.cartItems.remove(item);
                } else {
                    item.setQuantity(quantity);
                }
            }
//            if (item.getDienthoaiId().equals(dienthoaiId)) {
//                item.setQuantity(quantity);
//                break;
//            }
        }
    }
}

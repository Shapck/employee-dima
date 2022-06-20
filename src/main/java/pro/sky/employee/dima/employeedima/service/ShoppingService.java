package pro.sky.employee.dima.employeedima.service;

import pro.sky.employee.dima.employeedima.employee.ShoppingItem;

import java.util.List;

public interface ShoppingService {
    List<ShoppingItem> add(Integer id, String item);
    List<ShoppingItem> get();


}

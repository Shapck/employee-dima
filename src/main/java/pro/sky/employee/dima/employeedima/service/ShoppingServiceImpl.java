package pro.sky.employee.dima.employeedima.service;

import org.springframework.stereotype.Service;
import pro.sky.employee.dima.employeedima.employee.ShoppingBasket;
import pro.sky.employee.dima.employeedima.employee.ShoppingItem;

import java.util.List;
@Service
public class ShoppingServiceImpl implements ShoppingService{
    private ShoppingBasket shoppingBasket;

    public ShoppingServiceImpl(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    public List<ShoppingItem> add(Integer id, String item){
        ShoppingItem shoppingItem = new ShoppingItem(item,id);
        shoppingBasket.addItem(shoppingItem);
        return shoppingBasket.getShoppingItems();
    }

    public List<ShoppingItem> get() {
        return shoppingBasket.getShoppingItems();
        }
}

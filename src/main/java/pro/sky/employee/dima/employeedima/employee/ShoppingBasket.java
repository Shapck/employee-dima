package pro.sky.employee.dima.employeedima.employee;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.employee.dima.employeedima.employee.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class ShoppingBasket {
    public List<ShoppingItem> shoppingItems = new ArrayList<>();

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public List<ShoppingItem> addItem(ShoppingItem shoppingItem) {
        shoppingItems.add(shoppingItem);
        return shoppingItems;
    }
}

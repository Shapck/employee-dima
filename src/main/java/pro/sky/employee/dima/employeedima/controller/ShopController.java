package pro.sky.employee.dima.employeedima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.dima.employeedima.employee.ShoppingItem;
import pro.sky.employee.dima.employeedima.service.ShoppingService;

import java.util.List;

@RestController
public class ShopController {
    private final ShoppingService shoppingService;

    public ShopController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping(path = "/store/order/add")
    public List<ShoppingItem> add(@RequestParam("item") String item, @RequestParam("id") Integer id){
        return shoppingService.add(id, item);
    }

    @GetMapping(path = "/store/order/get")
    public List<ShoppingItem> get(){
        return shoppingService.get();
    }


}

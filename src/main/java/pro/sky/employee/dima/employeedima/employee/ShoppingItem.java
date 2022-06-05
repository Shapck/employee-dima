package pro.sky.employee.dima.employeedima.employee;

public class ShoppingItem {
    private String nameOfPurchase;
    private Integer id;


    public ShoppingItem(String nameOfPurchase, int id) {
        this.nameOfPurchase = nameOfPurchase;
        this.id = id;
    }

    public String getNameOfPurchase() {
        return nameOfPurchase;
    }

    public void setNameOfPurchase(String nameOfPurchase) {
        this.nameOfPurchase = nameOfPurchase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

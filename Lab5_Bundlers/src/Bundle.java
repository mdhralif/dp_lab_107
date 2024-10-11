import java.util.ArrayList;
import java.util.List;

public abstract class Bundle implements IProduct {
    protected String name;
    protected String description;
    protected double discount;

    public Bundle(String name, String description, double discount) {
        this.name = name;
        this.description = description;
        this.discount = discount;
    }


    public abstract List<IProduct> createBundle();

    public List<IProduct> getProducts() {
        return createBundle();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double total_price = 0;
        for (IProduct product : getProducts()) {
            total_price += product.getPrice();
        }
        return total_price - discount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Bundle: " + name + " | Discount: $" + discount + " | Description: " + description);
        for (IProduct product : getProducts()) {
            product.displayProductInfo();
        }
        System.out.println("Total Bundle Price (After Discount): $" + getPrice());
    }
}


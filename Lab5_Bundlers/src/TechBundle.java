import java.util.ArrayList;
import java.util.List;

public class TechBundle extends Bundle {

    public TechBundle() {
        super("Tech Bundle", "A collection of tech products", 5000);
    }

    @Override
    public List<IProduct> createBundle() {
        List<IProduct> products = new ArrayList<>();
        products.add(new SimpleProduct("Laptop", 150000, "Legion"));
        products.add(new SimpleProduct("Phone", 90000, "iphone15"));
        return products;
    }
}


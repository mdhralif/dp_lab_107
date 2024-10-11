import java.util.ArrayList;
import java.util.List;

public class AccessoriesBundle extends Bundle {

    public AccessoriesBundle() {
        super("Accessories Bundle", "A collection of electronic accessories", 500);
    }

    @Override
    public List<IProduct> createBundle() {
        List<IProduct> products = new ArrayList<>();
        products.add(new SimpleProduct("Mouse", 950, "Wireless mouse"));
        products.add(new SimpleProduct("Keyboard", 4500, "Havit Mechanical keyboard"));
        return products;
    }
}


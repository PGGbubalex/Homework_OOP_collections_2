import java.util.HashSet;
import java.util.Set;

public class ProductList {

    private Set<Products> products = new HashSet<>();

    public void addProduct(Products product) {
        if (products.contains(product)) {
            throw new IllegalArgumentException("Такой продукт уже есть");
        }
        products.add(product);
    }

    public void removeProduct(Products product) {
        if (!products.remove(product)) {
            throw new IllegalArgumentException("Такого продукта нет");
        }
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "products=" + products +
                '}';
    }
}

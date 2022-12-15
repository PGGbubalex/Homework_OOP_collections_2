import java.util.Objects;

public class Products {

    private String name;
    private float cost;
    private double requiredQuantity;

    public Products(String name, float cost, double requiredQuantity) {
        setCost(cost);
        setName(name);
        setRequiredQuantity(requiredQuantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Заполните карточку товара полностью");
        }
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("Заполните карточку товара полностью");
        }
        this.name = name;
    }

    public double getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(double requiredQuantity) {
        if (requiredQuantity <= 0) {
            throw new IllegalArgumentException("Заполните карточку товара полностью");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(name, products.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", requiredQuantity=" + requiredQuantity +
                '}';
    }
}

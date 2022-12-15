import java.util.Objects;

public class Recipe {

    private String name;

    private double sum;

    private ProductList productsInRecipe;

    public Recipe(String name, double sum, ProductList productsInRecipe) {
        setName(name);
        setSum(sum);
        setProductsInRecipe(productsInRecipe);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public ProductList getProductsInRecipe() {
        return productsInRecipe;
    }

    public void setProductsInRecipe(ProductList productsInRecipe) {
        this.productsInRecipe = productsInRecipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", productsInRecipe=" + productsInRecipe +
                '}';
    }
}

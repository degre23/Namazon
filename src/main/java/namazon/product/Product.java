package namazon.product;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private ProductCategory category;

    public Product(String name, Double price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return String.format("%s %.1f %s", name, price, category.name());
    }
}

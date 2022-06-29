package namazon.product;

public enum ProductCategory {
    ELECTRONICS("Game Console"), ATHLETICS("Football"), CLOTHING("Jeans"), HOME_APPLIANCES("Refrigerator");

    private String productName;

    ProductCategory(String productName) {
        this.productName = productName;

    }
}


package namazon.order;

import namazon.accounts.Address;
import namazon.product.Product;

public class Order {
    private Long id;
    private Product product;
    private Address destination;
    private OrderStatus status;

    public Order(Product product, Address destination, OrderStatus status) {
        this.product = product;
        this.destination = destination;
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s", product.toString(), destination.toString(), status);
    }

}

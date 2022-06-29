package namazon.order;

public enum OrderStatus {

    PENDING("Your order is pending."), SHIPPED("Your package has been shipped."), DELIVERED("Your package has been delivered!");

    private String nameStatus;

    OrderStatus(String nameStatus){
        this.nameStatus = nameStatus;
    }

    public String getNameStatus(){
        return nameStatus;
    }
}

package model;

public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String typeProduct;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(int id, String name, int quantity, int price, String typeProduct) {
        this.quantity=quantity;
        this.id = id;
        this.name = name;
        this.price = price;
        this.typeProduct = typeProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public String toString() {
        return "Sản Phẩm " +
                "| Id: " + id +
                "| Tên: " + name +
                "| Số Lượng: "+quantity+
                "| Giá: " + price +
                "| Loại: " + typeProduct ;
    }
}

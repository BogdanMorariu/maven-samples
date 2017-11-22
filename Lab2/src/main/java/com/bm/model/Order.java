package com.bm.model;

public class Order implements Comparable<Order>{
    private int id;
    private int price;
    private int quantity;

    public Order(int value) {
        this(value, value, value);
    }

    public Order(int id, int price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order aLong = (Order) o;

        if (id != aLong.id) return false;
        if (price != aLong.price) return false;
        return quantity == aLong.quantity;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + price;
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public int compareTo(Order aLong) {
        if(aLong.price* aLong.quantity > quantity*price)
            return 1;
        else
            return -1;
    }
}

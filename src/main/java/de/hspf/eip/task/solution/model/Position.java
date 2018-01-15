package de.hspf.eip.task.solution.model;

public class Position {
    
    private String orderno;
    private Number number;
    private double price;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Position{" + "orderno=" + orderno + ", number=" + number + ", price=" + price + '}';
    }
    
    
}

package de.hspf.eip.task.solution.model;

import java.util.List;


public class Order {
    
    private String customer;
    private String country;
    private String region;
    
    private List<Position> orderbody;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Position> getOrderbody() {
        return orderbody;
    }

    public void setOrderbody(List<Position> orderbody) {
        this.orderbody = orderbody;
    }

    @Override
    public String toString() {
        return "customer: " + customer;
    }
    
    
}

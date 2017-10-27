package com.jd.tx.service.designPattern.strategyPattern;

/**
 * Created by cdtangxi on 2017/10/27.
 */
public class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public void showName(){
        System.out.println("我是：" + name);
    }

    private TravelStrategy travelStrategy;

    public TravelStrategy getTravelStrategy() {
        return travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

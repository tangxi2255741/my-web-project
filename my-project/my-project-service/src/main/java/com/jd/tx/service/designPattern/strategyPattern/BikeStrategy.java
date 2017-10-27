package com.jd.tx.service.designPattern.strategyPattern;

/**
 * Created by cdtangxi on 2017/10/27.
 */
public class BikeStrategy implements TravelStrategy {
    @Override
    public void travel() {
        System.out.println("我现在正在骑自行车");
    }
}

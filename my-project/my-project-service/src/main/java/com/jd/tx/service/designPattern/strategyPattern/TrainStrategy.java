package com.jd.tx.service.designPattern.strategyPattern;

/**
 * Created by cdtangxi on 2017/10/27.
 */
public class TrainStrategy implements TravelStrategy {
    @Override
    public void travel() {
        System.out.println("我现在正在坐火车");
    }
}

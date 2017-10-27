package com.jd.tx.service;

import com.jd.tx.service.designPattern.strategyPattern.*;
import org.junit.Test;

/**
 * 策略模式
 * 把频繁变更的行为/算法封装起来，不同的人可以选择不同的出行方式。
 * 想换出行方式时，只需修改对应的策略就行；
 * 模式的组成
 * 容器类：@Person
 * 抽象策略类：TravelStrategy
 * 具体策略类：飞机、火车、自行车
 * Created by cdtangxi on 2017/10/27.
 */
public class StrategyPatternTest {

    @Test
    public void test(){
        Person zhangsan = new Person("zhangsan");
        zhangsan.setTravelStrategy(new TrainStrategy());
        doSomething(zhangsan);
        Person lisi = new Person("lisi");
        lisi.setTravelStrategy(new AirplaneStrategy());
        doSomething(lisi);
    }

    private void doSomething(Person person){
        person.showName();
        person.getTravelStrategy().travel();
    }
}

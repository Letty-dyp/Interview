package com.letty;

import java.math.BigDecimal;

public class MyTest {

    BigDecimal applePrice = new BigDecimal(8);
    BigDecimal strawPrice = new BigDecimal(13);
    BigDecimal mangoPrice = new BigDecimal(20);

    BigDecimal methodA(BigDecimal apple,BigDecimal strawberry,BigDecimal discount){
        if (discount == null){
            discount = new BigDecimal(100);
        }
        return  (apple.multiply(applePrice)).add(strawberry.multiply(strawPrice).
                multiply(discount).divide(new BigDecimal(100)));
    }

    BigDecimal methodB(BigDecimal apple,BigDecimal strawberry,BigDecimal mango,BigDecimal discount){
        BigDecimal totalA = methodA(apple,strawberry,discount);
        return  totalA.add(mango.multiply(mangoPrice));
    }

    BigDecimal methodD(BigDecimal apple,BigDecimal strawberry,BigDecimal mango,BigDecimal discount){
        BigDecimal total = methodA(apple,strawberry,discount).add(mango.multiply(mangoPrice));
        int reducePrice = total.intValue() / 100;
        return  total.subtract(new BigDecimal(reducePrice * 10)) ;
    }

    public static void main(String[] args) {
        /*
        * 三个入参时，第一个入参是苹果斤数，第二个是草莓斤数，第三个是折扣
        * 四个入参时，第一个入参是苹果斤数，第二个是草莓斤数，第三个是芒果斤数，第四个是折扣
        * */
        MyTest myTest = new MyTest();
        System.err.println("顾客A购买商品的总价如下：");
        System.err.println(myTest.methodA(new BigDecimal(0),new BigDecimal(2.25),null));
        System.err.println("顾客B购买商品的总价如下：");
        System.err.println(myTest.methodB(new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),null));
        System.err.println("顾客C购买商品的总价如下：");
        System.err.println(myTest.methodB(new BigDecimal(10),new BigDecimal(2.7),new BigDecimal(5),new BigDecimal(80)));
        System.err.println("顾客D购买商品的总价如下：");
        System.err.println(myTest.methodD(new BigDecimal(1),new BigDecimal(2),new BigDecimal(2),new BigDecimal(80)));

    }
}

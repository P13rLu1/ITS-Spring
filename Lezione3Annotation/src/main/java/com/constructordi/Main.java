package com.constructordi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        BeanA beanA = context.getBean(BeanA.class);

        System.out.println(beanA.hello());

        BeanB beanB = context.getBean(BeanB.class);

        System.out.println(beanB.hello());

    }
}
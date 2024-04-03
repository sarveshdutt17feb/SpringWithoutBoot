package config.xml.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("xml main started");
        ApplicationContext context = new ClassPathXmlApplicationContext("config/xml/beans/config.xml");
        Student s1 = context.getBean("student1", Student.class);
        s1.sayHello();
    }
}

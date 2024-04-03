package com.lcwd.withoutboot;

import anotherworld.Repo;
import anotherworld.RepoConfig;
import com.lcwd.withoutboot.beans.CartService;
import com.lcwd.withoutboot.beans.OrderService;
import com.lcwd.withoutboot.beans.UserService;
import com.lcwd.withoutboot.config.AppConfig;
import com.lcwd.withoutboot.web.AuthController;
import com.lcwd.withoutboot.web.HomeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Application Started" );
        //we have to create object of Application Context
        //this is annotation configuration
        //we can pass multiple configuration in AnnotationConfigApplicationContext if not given in componentScan ex - outside pakage config classes for beans
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, RepoConfig.class);
        System.out.println(context);
        CartService cartService1=context.getBean("cartService1", CartService.class);
        cartService1.createCart();

        OrderService orderService1 = context.getBean(OrderService.class);
        orderService1.createOrder();

        UserService userService1 = context.getBean(UserService.class);
        userService1.saveUser();
        //this is for xml based configuration
//        ApplicationContext context = new ClassPathXmlApplicationContext();

        HomeController ho = context.getBean(HomeController.class);
        ho.homePage();

        AuthController au = context.getBean(AuthController.class);
        au.login();

        Repo re = context.getBean(Repo.class);
        re.getUser();

    }
}

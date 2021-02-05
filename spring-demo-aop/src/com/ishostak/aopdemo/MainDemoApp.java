package com.ishostak.aopdemo;

import com.ishostak.aopdemo.dao.Account;
import com.ishostak.aopdemo.dao.AccountDAO;
import com.ishostak.aopdemo.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //retrieve bean from spring container
        AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);

        MemberShipDAO memberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

        dao.addAccount(new Account(), true);
        dao.doWork();

        memberShipDAO.goToSleep();
        memberShipDAO.addAccount();

        //close the context
        context.close();
    }
}

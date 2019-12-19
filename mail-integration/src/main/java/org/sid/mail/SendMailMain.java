package org.sid.mail;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SendMailMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SendMailMain.class, args);

        SendMailRoute sendMailRoute = new SendMailRoute();
        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(sendMailRoute);
            camelContext.start();
            Thread.sleep(5*60*1000);
            camelContext.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}

package org.sid.mail;

import org.apache.camel.builder.RouteBuilder;

public class SendMailRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct-vm:sendMail")
                .routeId("sending mail route")
                .autoStartup(true)
                .setHeader("subject", simple("sending sample mail"))
                .setHeader("to", simple("siddusrb@gmail.com,siddeshbs@hotmail.com"))
                .to("smtps://smtp.gmail.com?username=dummy@gmail.com&password=dummy");
    }
}

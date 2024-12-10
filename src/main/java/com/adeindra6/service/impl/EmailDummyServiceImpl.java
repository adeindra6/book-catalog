package com.adeindra6.service.impl;

import com.adeindra6.service.EmailService;

public class EmailDummyServiceImpl implements EmailService {
    @Override
    public void sendMail(String destinationAddress, String mailSubject, String messageContent) throws Exception {
        System.out.println("destination address: " + destinationAddress);
        System.out.println("mail subject: " + mailSubject);
        System.out.println("message content: " + messageContent);
    }
}

package com.adeindra6.service.impl;

import com.adeindra6.service.AuthService;
import com.adeindra6.service.EmailService;

public class AuthServiceImpl implements AuthService {
    private final EmailService emailService;

    public AuthServiceImpl(EmailService emailService) {
        super();
        this.emailService = emailService;
    }

    @Override
    public Boolean confirmOTP(String sessionId, String otp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean login(String email) throws Exception {
        emailService.sendMail(email, "Your OTP", "123456");
        return null;
    }
}

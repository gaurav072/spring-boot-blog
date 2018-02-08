package com.startwithjava.simpleblog.services.mail;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
public class SMTP {

    @Value("${smtp.host}")
    private String smtpHost;
    @Value("${smtp.username}")
    private String username;
    @Value("${smtp.password}")
    private String password;

    @Autowired
    Environment environment;
}
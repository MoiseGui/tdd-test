package com.example.ddd.infra.core;

import com.example.ddd.infra.core.messaging.LocalMessageReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractInfraImpl {
    @Autowired
    private LocalMessageReader localMessageReader;

    public String getMessage(String code) {
        String message= localMessageReader.getMessage(code);
        return message;
    }
}

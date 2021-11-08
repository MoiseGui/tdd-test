package com.example.ddd.infra.core;

import com.example.ddd.infra.core.messaging.LocalMessageReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractInfraImpl {
    @Autowired
    private LocalMessageReader localMessageReader;

    public String init(Class className){
        return "SELECT item FROM "+className.getSimpleName()+" item WHERE 1=1";
    }
    public String addCriteria(String key, Object valueMin,Object valueMax) {
        String query=addCriteria(key,valueMin,"<=");
         query+=addCriteria(key,valueMax,">=");
         return query;
    }
    public String addCriteria(String key, Object value, String operator) {
       if(value!=null && !value.toString().isEmpty()){
           if(value instanceof String && operator.equals("LIKE")){
               return " AND "+key+" "+operator+" '%"+value+"%'";
           }
           return " AND "+key+" "+operator+" '"+value+"'";
       }
       return "";
    }
    public String getMessage(String code) {
        String message= localMessageReader.getMessage(code);
        return message;
    }
}

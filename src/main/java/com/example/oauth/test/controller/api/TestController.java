package com.example.oauth.test.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Object> allUsers(){
        List<Map> users = new ArrayList<>();

        Map<String, java.io.Serializable> user1 = new HashMap<>();
        Map<String, java.io.Serializable> user2 = new HashMap<>();
        Map<String, java.io.Serializable> user3 = new HashMap<>();

        user1.put("id",1);
        user1.put("name","dip");

        user2.put("id",2);
        user2.put("name","mainul");

        user3.put("id",3);
        user3.put("name","user3");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return new ResponseEntity<Object>(users, HttpStatus.OK);
    }
}

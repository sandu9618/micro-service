package com.equitem.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/user-service-fallback")
    public String userServiceFallBackMethod(){
        return "User Service is taking longer than expected" +
                "Please try again later";
    }

    @GetMapping("/department-service-fallback")
    public String departmentServiceFallBackMethod(){
        return "Department Service is taking longer than expected" +
                "Please try again later";
    }
}

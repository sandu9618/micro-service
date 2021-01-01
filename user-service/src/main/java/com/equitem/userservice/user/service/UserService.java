package com.equitem.userservice.user.service;

import com.equitem.userservice.user.entity.User;
import com.equitem.userservice.user.repository.UserRepository;
import com.equitem.userservice.user.valueObjects.Department;
import com.equitem.userservice.user.valueObjects.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject(
                        "http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                        Department.class
                );

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}

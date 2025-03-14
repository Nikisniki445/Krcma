package com.example.demo.service;

import com.example.demo.helper.AgeHelper;
import com.example.demo.model.dto.*;
import com.example.demo.model.entity.User1;
import com.example.demo.model.entity.User1;
import com.example.demo.model.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User1Service {

    private final User1Repository user1Repository;

    public List<UserRow> getAllUsers() {
        List<User1> users = user1Repository.findAll();

        List<UserRow> userRows = users.stream()
                .map(user -> {

                    UserRow userRow = new UserRow();
                    userRow.setFirstName(user.getFirstName());
                    userRow.setLastName(user.getLastName());
                    userRow.setId(user.getId());
                    userRow.setIsAdult(AgeHelper.isAdult(LocalDate.from(user.getDateOfBirth())));

                    return userRow;

                })
                .collect(Collectors.toList());

        return userRows;
    }

    public UserDetail getUser1Detail(Long userId) {

        User1 user = user1Repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User1 not found!"));


        UserDetail userDetail = new UserDetail();

        userDetail.setId(user.getId());
        userDetail.setFirstName(user.getFirstName());
        userDetail.setLastName(user.getLastName());
        userDetail.setDateOfBirth(LocalDate.from(user.getDateOfBirth()));
        userDetail.setIsAdult(AgeHelper.isAdult(LocalDate.from(user.getDateOfBirth())));
        userDetail.setAge(AgeHelper.getAge(LocalDate.from(user.getDateOfBirth())));

        userDetail.setCreatedAt(LocalDateTime.now());
        userDetail.setUpdatedAt(LocalDateTime.now());


        return userDetail;
    }

    public void createUser1(UserCreatePayload payload) {

        User1 user = new User1();
        user.setFirstName(payload.getFirstName());
        user.setLastName(payload.getLastName());
        user.setDateOfBirth(LocalDate.from(payload.getDateOfBirth().atStartOfDay()));
        user.setCreatedAt(LocalDateTime.now());

        user1Repository.save(user);
    }

    public void updateUser1(Long id, UserUpdatePayload payload) {

        User1 user = user1Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User1 not found!"));

        user.setFirstName(payload.getFirstName());
        user.setLastName(payload.getLastName());
        user.setUpdatedAt(LocalDateTime.now());

        user1Repository.save(user);
    }


    public void deleteUser1(Long userId) {

        User1 user = user1Repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User1 not found!"));

        user1Repository.delete(user);
    }



}







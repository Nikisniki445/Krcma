package com.example.demo.application;

import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository userRepository;

   public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
       for (int i = 0; i < users.size(); i++) {
           userDtoList.add(new UserDto(users.get(i).getId(),
                                       users.get(i).getFirstName(),
                                       users.get(i).getLastName(),
                                       users.get(i).getAge(),
                                       users.get(i).getDateOfBirth(),
                                       users.get(i).getIsAdult() ));
       }

       return userDtoList;

   }

    public UserDto getUserById(Long id) throws Exception {
       User user = userRepository.findById(id).orElseThrow(() -> new Exception("Uzivatel nebyl nalezen"));

       return new UserDto(user.getId(),
               user.getFirstName(),
               user.getLastName(),
               user.getAge(),
               user.getDateOfBirth(),
               user.getIsAdult());
    }

    public void saveUser(UserDto userDto) {

       User user = new User(null,
               userDto.getFirstName(),
               userDto.getLastName(),
               userDto.getAge(),
               userDto.getIsAdult(),
               userDto.getDateOfBirth());

       userRepository.save(user);



    }
}

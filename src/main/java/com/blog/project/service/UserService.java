package com.blog.project.service;


import com.blog.project.domain.Users;
import com.blog.project.exception.UserNotFound;
import com.blog.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users createUser(String userName, String email, String password){
        Users user = Users.builder()
                .userName(userName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();

        userRepository.save(user);
        return user;
    }

    public void changeUserPwd(String userName,String pwd){
        Users user = userRepository.findByuserName(userName).orElseThrow(UserNotFound::new);
        user.passwordUpdate(passwordEncoder.encode(pwd));
        userRepository.save(user);
    }

    public Users getUser(String userName){
        Optional<Users> user = userRepository.findByuserName(userName);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new UserNotFound();
        }
    }

    public boolean checkEmailDuplicated(String email){
        return userRepository.existsByEmail(email);
    }

    public boolean checkIdDuplicated(String Id){
        return userRepository.existsByUserName(Id);
    }

}

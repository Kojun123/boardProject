package com.blog.project.dto.user;

import com.blog.project.domain.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String userName;
    private String password;
    private String email;

    @Builder
    public UserDto(Long id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Users toEntity(){
        Users user = Users.builder()
                .id(id)
                .userName(userName)
                .password(password)
                .email(email)
                .build();
        return user;
    }
}

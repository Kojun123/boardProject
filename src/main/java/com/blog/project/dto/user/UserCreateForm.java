package com.blog.project.dto.user;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserCreateForm {

    @Size(min = 3,max = 15)
    @NotEmpty(message = "사용자 ID는 필수항목입니다.")
    @NotBlank
    private String userName;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    @NotBlank
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    @NotBlank
    private String password2;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @NotBlank
    @Email
    private String email;
}

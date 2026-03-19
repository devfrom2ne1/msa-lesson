package com.sparta.msa.lesson.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

  // POST /users <- 유저를 만들때 들어가는 body

  @NotBlank(message = "공백은 사용할 수 없습니다.")
  String name;

  @NotNull
  @Size(min = 1, max = 50)
  String email;

  String password;

  public Long getId() {
    return null;
  }
}

package com.sparta.msa.lesson.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAuthRequest {

  // PATCH /users/{id}/auth <- 유저에 인증정보를 업데이트 해라
  String password;
}

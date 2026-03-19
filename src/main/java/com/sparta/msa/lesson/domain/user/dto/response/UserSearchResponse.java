package com.sparta.msa.lesson.domain.user.dto.response;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSearchResponse {

  // GET /users <= 유저 정보를 줄 때 사용 (**다건** 조회)
  Long id;
  String name;
  String email;
  LocalDateTime createdAt;
}

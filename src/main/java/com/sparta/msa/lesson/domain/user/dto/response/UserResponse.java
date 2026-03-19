package com.sparta.msa.lesson.domain.user.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

  // GET /users/{id} <= 유저 정보를 줄 때 사용 (단건조회)
  // 역할 : 상세 조회
  Long id;
  String name;
  String email;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDateTime createdAt;
}

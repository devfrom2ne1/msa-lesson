package com.sparta.msa.lesson.domain.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInfoDto {

  Long id;
  String name;
  String email;
  Boolean isActive;

  @Builder
  public UserInfoDto(Long id, String name, String email, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.isActive = isActive;
  }
}

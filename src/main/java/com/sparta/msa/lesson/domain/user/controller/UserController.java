package com.sparta.msa.lesson.domain.user.controller;

import com.sparta.msa.lesson.domain.user.dto.request.UserRequest;
import com.sparta.msa.lesson.domain.user.dto.response.UserResponse;
import com.sparta.msa.lesson.domain.user.service.UserService;
import com.sparta.msa.lesson.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  // TODO : 회원정보 조회
  @GetMapping("/{id}")
  public ApiResponse<UserResponse> findById(@PathVariable Long id) {
    return ApiResponse.ok();
  }

  // TODO : 로그인
  @GetMapping("/login")

  // TODO : 회원가입
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED) // HTTP 상태코드 지정이 가능하다.
  public ApiResponse<UserResponse> save(@Valid @RequestBody UserRequest request) {
    return ApiResponse.ok(userService.save(request));
  }

  // TODO : 패스워드 변경

  // TODO : 회원탈퇴
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ApiResponse<Void> delete(@PathVariable Long id) {
    // userService.deleteById(id);
    return ApiResponse.ok();
  }


}
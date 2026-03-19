package com.sparta.msa.lesson.domain.user.service;

import com.sparta.msa.lesson.domain.user.dto.request.UserRequest;
import com.sparta.msa.lesson.domain.user.dto.response.UserResponse;
import com.sparta.msa.lesson.domain.user.entity.User;
import com.sparta.msa.lesson.domain.user.mapper.UserMapper;
import com.sparta.msa.lesson.domain.user.repository.UserRepository;
import com.sparta.msa.lesson.global.exception.DomainException;
import com.sparta.msa.lesson.global.exception.DomainExceptionCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  @Transactional // service안에 있는 public메소드는 모두 트랜젝션 처리가 되어야 함
  public UserResponse save(UserRequest request) {

    // 비영속
    User user = userMapper.toEntity(request, "encodePassword");

    // 영속
    userRepository.save(user);

    // 영속
    User userCheckEmail = userRepository.findByEmail(request.getEmail()).get();

    // RemovedTKDO

    // 이메일 중복체크
    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
      throw new DomainException(DomainExceptionCode.DUPLICATE_EMAIL);
    }

    // 비밀번호 암호화
    String encodePassword = request.getPassword();

    // 회원가입(DB저장)
    User user = userRepository.save(userMapper.toEntity(request, encodePassword));
    return userMapper.toUserResponse(user);
  } // 메소드 종료 == 트랜젝션이 종료된 시점 준영속(Detached) && Removed 발생

}

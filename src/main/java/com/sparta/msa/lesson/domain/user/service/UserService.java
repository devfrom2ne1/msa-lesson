package com.sparta.msa.lesson.domain.user.service;

import com.sparta.msa.lesson.domain.user.dto.request.UserRequest;
import com.sparta.msa.lesson.domain.user.dto.response.UserResponse;
import com.sparta.msa.lesson.domain.user.entity.User;
import com.sparta.msa.lesson.domain.user.mapper.UserMapper;
import com.sparta.msa.lesson.domain.user.repository.UserRepository;
import com.sparta.msa.lesson.global.exception.DomainException;
import com.sparta.msa.lesson.global.exception.DomainExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  @Transactional(readOnly = true)
  public void getById(Long userId) {
    userRepository.findById(userId);
  }

  @Transactional // service안에 있는 public메소드는 모두 트랜젝션 처리가 되어야 함
  public UserResponse update(UserRequest request) {

    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new DomainException(DomainExceptionCode.NOT_FOUND_USER)); // 스냅샷

    userRepository.findUserWithOrders(
        request.getId()); // flush 실행여부(FlushModeType에 따라 다르지만, 보통AUTO면 JPQL실행 전에 flush나감

    // 변경감지
    user.setName(request.getName());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setEmail(request.getEmail());

    User user2 = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new DomainException(DomainExceptionCode.NOT_FOUND_USER)); // 스냅샷

    return userMapper.toUserResponse(user);
  }

}

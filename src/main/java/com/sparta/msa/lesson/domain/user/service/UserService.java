package com.sparta.msa.lesson.domain.user.service;

import com.sparta.msa.lesson.domain.user.dto.request.UserRequest;
import com.sparta.msa.lesson.domain.user.dto.response.UserResponse;
import com.sparta.msa.lesson.domain.user.entity.User;
import com.sparta.msa.lesson.domain.user.mapper.UserMapper;
import com.sparta.msa.lesson.domain.user.repository.UserRepository;
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
  public UserResponse save(UserRequest request) {

    // 중복된 이메일을 가진 유저가 있으면, 기존 유저를 제거
    User checkUser = userRepository.findById(request.getId()).get(); // 영속성 컨텍스트에 존재

    User user = userMapper.toEntity(request, ""); // 비영속

    User savedUser = userRepository.save(
        user); // 영속 : 이 메소드가 종료될때가 아닌!!! 트랜젝션 종료 시점에 flush+save가 발생한다.

    // DB를 거쳐야만 얻을 수 있는 정보인 id, createdAt, join 값들은
    // flush() -> 데이터베이스에 쿼리를 실행시키는 메소드(쿼리를 날라가게 강제하는 메소드)
    // DB를 갔다온다.

    User checkUser2 = userRepository.findById(request.getId())
        .get(); // 영속성 컨텐스트에 존재하는 값을 가져옴(쿼리실행x)
    // => 즉, checkUser === checkUser2 완전히 동일하다.

    // 동기화 관리함
    // 트랜젝션은 독립적으로 실행됨(격리성)
    // user가 중간에 변경되면 어떻게 되냐?
    // 트랜젝션 레벨 격리 레벨 설정에 의해서 동기화 여부가 관리가 된다.
  }

}

package com.sparta.msa.lesson.domain.order.service;

import com.sparta.msa.lesson.domain.order.entity.Order;
import com.sparta.msa.lesson.domain.order.repository.OrderRepository;
import com.sparta.msa.lesson.domain.user.entity.User;
import com.sparta.msa.lesson.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

  private final UserRepository userRepository;
  private final OrderRepository orderRepository;

  public void getById(Long id) {
    // Order 엔티티에 User를 LAZY로딩으로 선언했기 때문에 프록시객체만 가져온다.
    Order order = orderRepository.findById(id).get();
    User user = order.getUser(); // 이때 실제 User객체를 가져오게 된다.
  }

}
;
package com.sparta.msa.lesson.domain.user.service;

import com.sparta.msa.lesson.domain.order.entity.Order;
import com.sparta.msa.lesson.domain.order.repository.OrderRepository;
import com.sparta.msa.lesson.domain.user.entity.User;
import com.sparta.msa.lesson.domain.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final OrderRepository orderRepository;

  public void getUser() {
    User user = userRepository.findById(1L).get();

    // 아래 둘 다 사용 가능!
    List<Order> orders = orderRepository.findByUser(user);
    //List<Order> orders = user.getOrders();
  }

}

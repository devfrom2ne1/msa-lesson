package com.sparta.msa.lesson.domain.product.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor // jkson라이브러리에서 생성자가 없으면 인식을 못하기 때문에 필수!
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

  Long id;

  @NotNull
  String name;

  String description;

  @NotNull
  @Positive // 양수만허용(0허용x)
  BigDecimal price;

  @NotNull
  @PositiveOrZero // 0 또는 양수만 허용
  Integer stock;

}

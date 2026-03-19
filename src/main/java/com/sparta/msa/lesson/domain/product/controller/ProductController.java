package com.sparta.msa.lesson.domain.product.controller;

import com.sparta.msa.lesson.domain.product.dto.request.ProductRequest;
import com.sparta.msa.lesson.domain.product.dto.request.ProductStockRequest;
import com.sparta.msa.lesson.domain.product.dto.response.ProductResponse;
import com.sparta.msa.lesson.domain.product.service.ProductService;
import com.sparta.msa.lesson.global.response.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController// controller : API 요청을 가장 먼저 받는 클래스로 인식
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;

  // API [GET] /api/products?name="전화기"
  @GetMapping
  public ApiResponse<List<ProductResponse>> findById(@RequestParam(name = "name") String name) {
    return ApiResponse.ok(productService.getAllProducts());
  }

  // API [GET] /api/products/{id}
  @GetMapping("/{id}")
  public ApiResponse<ProductResponse> findById(@PathVariable Long id) {
    return ApiResponse.ok(productService.getProductById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED) // HTTP 상태코드 지정이 가능하다.
  public ApiResponse<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
    return ApiResponse.ok(productService.create(request));
  }

  @PutMapping("{id}")
  public ApiResponse<ProductResponse> update(@PathVariable Long id,
      @RequestBody ProductStockRequest request) {
    return ApiResponse.ok(productService.update(id, request));
  }

  @PutMapping("{id}/stock")
  public ApiResponse<ProductResponse> updateStock(@PathVariable Long id,
      @RequestBody ProductStockRequest request) {
    return ApiResponse.ok(productService.updateStock(id, request.getStock()));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ApiResponse<Void> delete(@PathVariable Long id) {
    productService.deleteById(id);
    return ApiResponse.ok();
  }
}

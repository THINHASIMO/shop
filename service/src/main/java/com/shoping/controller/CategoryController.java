package com.shoping.controller;

import com.shoping.controller.common.BaseController;
import com.shoping.controller.common.BaseSearchController;
import com.shoping.dto.CategorySearchDto;
import com.shoping.entity.CategoryEntity;
import com.shoping.services.CategoryService;
import com.shoping.utils.ResponseHandler;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@Log4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<CategoryEntity, Long> implements BaseSearchController<CategorySearchDto> {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        super(service);
        this.service = service;
    }

    @Override
    public ResponseEntity<Object> getPage(@Valid CategorySearchDto categorySearchDto) {
        return ResponseHandler.generateResponse(HttpStatus.OK, "", service.page(categorySearchDto));
    }
}

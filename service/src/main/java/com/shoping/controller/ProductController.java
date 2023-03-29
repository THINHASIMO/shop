package com.shoping.controller;

import com.shoping.controller.common.BaseController;
import com.shoping.controller.common.BaseSearchController;
import com.shoping.dto.ProductSearchDto;
import com.shoping.entity.ProductEntity;
import com.shoping.services.ProductService;
import com.shoping.utils.ResponseHandler;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Log4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController<ProductEntity, Long> implements BaseSearchController<ProductSearchDto> {

    private final ProductService service;

    @Autowired
    protected ProductController(ProductService service) {
        super(service);
        this.service = service;
    }

    @Override
    public ResponseEntity<Object> getPage(@Valid ProductSearchDto product) {
        return ResponseHandler.generateResponse(HttpStatus.OK, "", service.page(product));
    }
}

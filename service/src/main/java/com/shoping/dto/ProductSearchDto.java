package com.shoping.dto;

import com.shoping.dto.common.SearchDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class ProductSearchDto extends SearchDto {
    private Integer quantity;
    private Long price;

    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private String type;
    private String sku;
    private String discount;
    private String shop;
    private String content;
}

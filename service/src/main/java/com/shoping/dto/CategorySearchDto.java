package com.shoping.dto;

import com.shoping.dto.common.SearchDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategorySearchDto extends SearchDto {
    private Integer parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String content;
}

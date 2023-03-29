package com.shoping.dto;

import com.shoping.dto.common.SearchDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class ProductSearchDto extends SearchDto {
    private String title;
}

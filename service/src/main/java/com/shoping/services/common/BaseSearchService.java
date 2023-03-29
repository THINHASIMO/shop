package com.shoping.services.common;

import com.shoping.dto.common.SearchDto;
import org.springframework.data.domain.Page;

public interface BaseSearchService<T, S extends SearchDto> {
    Page<T> page(S s);
}

package com.tutorial.common.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class BaseCriteria {
    private Integer page;
    private Integer perPage;
    private Sort.Direction direction;
    private String sort;
}

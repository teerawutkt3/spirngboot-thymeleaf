package com.tutorial.project.persons.vo;

import com.tutorial.common.beans.BaseCriteria;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PersonCriteria extends BaseCriteria {
    private Long id;
    private String name;
    private String last;
    private String age;
    private String city;

}

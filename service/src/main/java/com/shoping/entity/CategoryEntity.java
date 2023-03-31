package com.shoping.entity;

import com.shoping.entity.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity extends BaseEntity {
    private Integer parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String content;
}

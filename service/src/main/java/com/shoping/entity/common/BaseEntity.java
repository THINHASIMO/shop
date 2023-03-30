package com.shoping.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pageIndex;
    private int pageSize;
    private boolean isDeleted;

    public int getOrDefaultPageIndex() {
        return pageIndex <= 0 ? 0 : pageIndex - 1;
    }

    public int getOrDefaultPageSize() {
        return pageSize == 0 ? 10 : pageSize;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updatedAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publishedAt;
}

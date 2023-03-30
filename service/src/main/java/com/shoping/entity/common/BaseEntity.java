package com.shoping.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Transient
    protected Map<String, String> attributes = new HashMap();

    @Column(name = "is_deleted")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private boolean isDeleted = false;

    @Column(name = "created_by")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Long createdBy;

    @CreatedDate
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Ho_Chi_Minh")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date createdAt = new Date();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Ho_Chi_Minh")
    @Column(name = "updated_by")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Long updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Ho_Chi_Minh")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date updatedAt;

    public BaseEntity() {
    }

    public Map<String, String> getAttributes() {
        this.setAttributes();
        return this.attributes;
    }

    public void setAttributes() {
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    @JsonIgnore
    public void setAttributes(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @JsonIgnore
    public void setDeleted(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnore
    public void setCreatedBy(final Long createdBy) {
        this.createdBy = createdBy;
    }

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            timezone = "Asia/Ho_Chi_Minh"
    )
    @JsonIgnore
    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    @JsonIgnore
    public void setUpdatedBy(final Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            timezone = "Asia/Ho_Chi_Minh"
    )
    @JsonIgnore
    public void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

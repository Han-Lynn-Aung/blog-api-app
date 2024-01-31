package com.natrix.blogapi.BlogApiApplication.model;

import com.natrix.blogapi.BlogApiApplication.model.audit.UserDateAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "todos", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) })
public class Todo extends UserDateAudit {

    @NotBlank
    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private Boolean completed;
}

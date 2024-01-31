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
@Data
@Entity
@Table(name = "albums", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Album extends UserDateAudit {

    @NotBlank
    @Column(name = "title")
    private String title;

}

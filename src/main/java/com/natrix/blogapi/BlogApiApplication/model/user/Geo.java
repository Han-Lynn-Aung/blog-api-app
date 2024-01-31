package com.natrix.blogapi.BlogApiApplication.model.user;

import com.natrix.blogapi.BlogApiApplication.model.audit.UserDateAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "geo")
public class Geo extends UserDateAudit {

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;
}

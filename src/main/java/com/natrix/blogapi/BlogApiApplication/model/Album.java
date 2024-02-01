package com.natrix.blogapi.BlogApiApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.natrix.blogapi.BlogApiApplication.model.audit.UserDateAudit;
import com.natrix.blogapi.BlogApiApplication.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "albums", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Album extends UserDateAudit {

    @NotBlank
    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    (mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos;

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public List<Photo> getPhotos() {
        return this.photos == null ? null : new ArrayList<>(this.photos);
    }

    public void setPhotos(List<Photo> photos) {
        if (photos == null) {
            this.photos = null;
        }else {
            this.photos = Collections.unmodifiableList(photos);
        }
    }

}

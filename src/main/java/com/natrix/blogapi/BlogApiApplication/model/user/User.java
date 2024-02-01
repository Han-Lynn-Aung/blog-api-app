package com.natrix.blogapi.BlogApiApplication.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.natrix.blogapi.BlogApiApplication.model.Album;
import com.natrix.blogapi.BlogApiApplication.model.Comment;
import com.natrix.blogapi.BlogApiApplication.model.Post;
import com.natrix.blogapi.BlogApiApplication.model.Todo;
import com.natrix.blogapi.BlogApiApplication.model.audit.UserDateAudit;
import com.natrix.blogapi.BlogApiApplication.model.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
        @UniqueConstraint(columnNames = { "email" }) })
public class User extends UserDateAudit {

    @NotBlank
    @Column(name = "first_name")
    @Size(max = 40)
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    @Size(max = 40)
    private String lastName;

    @NotBlank
    @Column(name = "username")
    @Size(max = 15)
    private String username;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @NotBlank
    @NaturalId
    @Size(max = 40)
    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "website")
    private String website;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Album> albums;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Todo> todos;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;


    @OneToOne(mappedBy = "user")
    @JoinColumn(name= "company_id")
    private Company company;


    @JsonIgnore
    public List<Role> getRoles() {
        return roles == null ? null : new ArrayList<>(roles);
    }

    public void setRoles(List<Role> roles) {
        if (roles == null) {
            this.roles = null;
        }else {
           this.roles = Collections.unmodifiableList(roles);
        }
    }

    @JsonIgnore
    public List<Album> getAlbums() {
        return albums == null ? null : new ArrayList<>(albums);
    }

    public void setAlbums(List<Album> albums) {
        if (albums == null) {
            this.albums = null;
        }else {
            this.albums = Collections.unmodifiableList(albums);
        }
    }

    @JsonIgnore
    public List<Post> getPosts() {
        return posts == null ? null :  new ArrayList<>(posts);
    }

    public void setPosts(List<Post> posts) {
        if (posts == null) {
            this.posts = null;
        }
        else {
            this.posts = Collections.unmodifiableList(posts);
        }
    }

    @JsonIgnore
    public List<Comment> getComments() {
        return comments == null ? null : new ArrayList<>(comments);
    }

    public void setComments(List<Comment> comments) {
        if (comments == null) {
            this.comments = null;
        }
        else {
            this.comments = Collections.unmodifiableList(comments);
        }
    }

    @JsonIgnore
    public List<Todo> getTodos() {
        return todos == null ? null : new ArrayList<>(todos);
    }

    public void setTodos(List<Todo> todos) {
        if (todos == null) {
            this.todos = null;
        }
        else {
            this.todos = Collections.unmodifiableList(todos);
        }
    }
}

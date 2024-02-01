package com.natrix.blogapi.BlogApiApplication.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.natrix.blogapi.BlogApiApplication.model.Photo;
import com.natrix.blogapi.BlogApiApplication.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class AlbumResponse {

    private String title;

    private User user;

    private List<Photo> photo;

}

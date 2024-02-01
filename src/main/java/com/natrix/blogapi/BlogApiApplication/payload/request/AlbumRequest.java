package com.natrix.blogapi.BlogApiApplication.payload.request;

import com.natrix.blogapi.BlogApiApplication.model.Photo;
import com.natrix.blogapi.BlogApiApplication.model.user.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class AlbumRequest {

    private String title;

    private User user;

    private List<Photo> photo;

    public List<Photo> getPhoto() {

        return photo == null ? null : new ArrayList<>(photo);
    }

    public void setPhoto(List<Photo> photo) {

        if (photo == null) {
            this.photo = null;
        } else {
            this.photo = Collections.unmodifiableList(photo);
        }
    }
}

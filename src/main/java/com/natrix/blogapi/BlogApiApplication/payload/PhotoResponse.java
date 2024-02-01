package com.natrix.blogapi.BlogApiApplication.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoResponse {

    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;
    private Long albumId;

}

package com.natrix.blogapi.BlogApiApplication.service;

import com.natrix.blogapi.BlogApiApplication.model.Album;
import com.natrix.blogapi.BlogApiApplication.payload.AlbumResponse;
import com.natrix.blogapi.BlogApiApplication.payload.ApiResponse;
import com.natrix.blogapi.BlogApiApplication.payload.PageResponse;
import com.natrix.blogapi.BlogApiApplication.payload.request.AlbumRequest;
import com.natrix.blogapi.BlogApiApplication.security.UserPrincipal;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

public interface AlbumService {

    PageResponse<AlbumResponse> getAllAlbums(Specification<Album> spec, int page, int size);

    ResponseEntity<Album> addAlbums(AlbumRequest albumRequest, UserPrincipal userPrincipal);

    ResponseEntity<Album> getAlbumById(Long id);

    ResponseEntity<AlbumResponse> updateAlbum(AlbumRequest albumRequest, UserPrincipal currentUser);

    ResponseEntity<ApiResponse> deleteAlbum(Long id, UserPrincipal currentUser);

    PageResponse<Album> getAllUserAlbum(Specification<Album> spec, String username, int page, int size);


}

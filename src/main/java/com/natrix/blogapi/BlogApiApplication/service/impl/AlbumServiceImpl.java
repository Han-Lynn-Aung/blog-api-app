package com.natrix.blogapi.BlogApiApplication.service.impl;

import com.natrix.blogapi.BlogApiApplication.model.Album;
import com.natrix.blogapi.BlogApiApplication.model.user.User;
import com.natrix.blogapi.BlogApiApplication.payload.AlbumResponse;
import com.natrix.blogapi.BlogApiApplication.payload.ApiResponse;
import com.natrix.blogapi.BlogApiApplication.payload.PageResponse;
import com.natrix.blogapi.BlogApiApplication.payload.request.AlbumRequest;
import com.natrix.blogapi.BlogApiApplication.repository.AlbumRepository;
import com.natrix.blogapi.BlogApiApplication.repository.UserRepository;
import com.natrix.blogapi.BlogApiApplication.security.UserPrincipal;
import com.natrix.blogapi.BlogApiApplication.service.AlbumService;
import com.natrix.blogapi.BlogApiApplication.utils.AppUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private static final String CREATED_AT = "createdAt";

    private static final String ALBUM_STR = "Album";

    private static final String YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION = "You don't have permission to make this operation";


    private final AlbumRepository albumRepository;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public PageResponse<AlbumResponse> getAllAlbums(Specification<Album> spec, int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);

        Page<Album> albums = albumRepository.findAll(spec, pageable);

        if (albums.getNumberOfElements() == 0) {
            return new PageResponse<>(Collections.emptyList(), albums.getNumber(), albums.getSize(), albums.getTotalElements(),
                    albums.getTotalPages(), albums.isLast());
        }

        List<AlbumResponse> albumResponses = Arrays.asList(modelMapper.map(albums.getContent(), AlbumResponse[].class));

        return new PageResponse<>(Collections.emptyList(), albums.getNumber(), albums.getSize(), albums.getTotalElements(),
                albums.getTotalPages(), albums.isLast());
    }

    @Override
    public ResponseEntity<Album> addAlbums(AlbumRequest albumRequest, UserPrincipal currentUser) {

        User user = userRepository.getUser(currentUser);

        Album album = new Album();

        modelMapper.map(albumRequest, album);

        album.setUser(user);

        Album newAlbum = albumRepository.save(album);

        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Album> getAlbumById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AlbumResponse> updateAlbum(AlbumRequest albumRequest, UserPrincipal currentUser) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> deleteAlbum(Long id, UserPrincipal currentUser) {
        return null;
    }

    @Override
    public PageResponse<Album> getAllUserAlbum(Specification<Album> spec, String username, int page, int size) {
        return null;
    }
}

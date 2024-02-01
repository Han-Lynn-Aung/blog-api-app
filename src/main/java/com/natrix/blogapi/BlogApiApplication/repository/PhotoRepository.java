package com.natrix.blogapi.BlogApiApplication.repository;

import com.natrix.blogapi.BlogApiApplication.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends BaseRepository<Photo,Long> {

    Page<Photo> findByAlbum(Long albumId, Pageable pageable);
}

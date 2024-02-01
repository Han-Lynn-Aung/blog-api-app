package com.natrix.blogapi.BlogApiApplication.repository;

import com.natrix.blogapi.BlogApiApplication.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends BaseRepository<Album,Long> {

    Page<Album> findByCreateBy(Long userId, Pageable pageable);
}

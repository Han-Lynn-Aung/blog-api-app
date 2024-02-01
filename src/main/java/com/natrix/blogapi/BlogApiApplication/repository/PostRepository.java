package com.natrix.blogapi.BlogApiApplication.repository;

import com.natrix.blogapi.BlogApiApplication.model.Post;
import com.natrix.blogapi.BlogApiApplication.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends BaseRepository<Post, Long>{

    Page<Post> findByCreateBy(Long userId,Pageable pageable);

    Page<Post> findByCategory(Long categoryId,Pageable pageable);

    Page<Post> findByTags(List<Tag> tags, Pageable pageable);

    Long countByCreateBy(Long userId);
}

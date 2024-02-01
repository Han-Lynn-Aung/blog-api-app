package com.natrix.blogapi.BlogApiApplication.repository;

import com.natrix.blogapi.BlogApiApplication.model.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends BaseRepository<Tag,Long>{

    Tag findByName(String name);
}

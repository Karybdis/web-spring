package com.example.demo.Repository;

import com.example.demo.Entity.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag,Long>
{
    Tag findByTagName(String tagName);
}

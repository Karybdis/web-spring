package com.example.demo.Repository;

import com.example.demo.Entity.ContestTag;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ContestTagRepository extends CrudRepository<ContestTag,Long>
{
    ArrayList<ContestTag> findByContestId(Long id);
}

package com.example.demo.Repository;

import com.example.demo.Entity.Contest;
import org.springframework.data.repository.CrudRepository;

public interface ContestRepository extends CrudRepository<Contest,Long>
{
    Contest findByContestName(String contestName);
}

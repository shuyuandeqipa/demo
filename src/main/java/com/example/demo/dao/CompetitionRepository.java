package com.example.demo.dao;

import com.example.demo.entity.Competition;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("competitionRepository")
public interface CompetitionRepository extends PagingAndSortingRepository<Competition,Integer>,
        CrudRepository<Competition,Integer> {
     public Competition findCompetitionById(Integer id);

}

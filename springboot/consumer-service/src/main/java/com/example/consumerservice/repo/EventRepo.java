package com.example.consumerservice.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.example.consumerservice.model.Event;


@Qualifier("eventRepo")
@EnableJpaRepositories
public interface EventRepo extends JpaRepository<Event, String>{

    @Query("SELECT e from Event e where e.num=:id")
    public List<Event> findById(@Param("id") float id);

}
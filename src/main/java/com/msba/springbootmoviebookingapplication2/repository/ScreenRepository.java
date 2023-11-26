package com.msba.springbootmoviebookingapplication2.repository;

import com.msba.springbootmoviebookingapplication2.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    @Query(value = "select * from screens as u where u.theatre_id = :id", nativeQuery = true)
    List<Screen> findByTheatreId(@Param("id") long id);
}

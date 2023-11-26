package com.msba.springbootmoviebookingapplication2.repository;

import com.msba.springbootmoviebookingapplication2.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    @Query(value = "select * from theatres as u where u.theatre_name = :name", nativeQuery = true)
    Theatre findByTheatreName(@Param("name") String theatreName);
    @Query(value = "select * from theatres as u where u.theatre_name = :name AND u.theatre_city = :city", nativeQuery = true)
    Theatre findByTheatreNameAndTheatreCity(@Param("name") String theatreName, @Param("city") String theatreCity);
}

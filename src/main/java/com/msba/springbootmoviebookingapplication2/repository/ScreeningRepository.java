package com.msba.springbootmoviebookingapplication2.repository;

import com.msba.springbootmoviebookingapplication2.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    @Query(value = "select * from screenings as u where u.movie_name = :name AND u.theatre_id = :id AND u.screening_date = :date", nativeQuery = true)
    Screening findByMovieNameAndTheatreIdAndScreeningDate(@Param("name")String movieName, @Param("id") long theatreId, @Param("date") String ScreeningDate);

    @Query(value = "select * from screenings as u where u.screening_date = :date", nativeQuery = true)
    Screening findByScreeningDate(@Param("date") String screeningDate);
}

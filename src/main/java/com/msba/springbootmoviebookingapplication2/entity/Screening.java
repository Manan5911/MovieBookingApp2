package com.msba.springbootmoviebookingapplication2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screeningId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    private Long theatreId;
    @JsonIgnore
    @OneToOne(mappedBy = "screening")
    private Long screenId;
    @Column(nullable = false)
    private String movieName;
    @Column(nullable = false)
    private Date screeningDate;
    @Column(nullable = false)
    private Long bookedTickets;
}

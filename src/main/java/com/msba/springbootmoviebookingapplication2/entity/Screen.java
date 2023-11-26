package com.msba.springbootmoviebookingapplication2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="screens")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    private Long theatreId;
    @Column(nullable = false)
    private Long seatsNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screening_id", referencedColumnName = "screening_id")
    private Screening screening;

}

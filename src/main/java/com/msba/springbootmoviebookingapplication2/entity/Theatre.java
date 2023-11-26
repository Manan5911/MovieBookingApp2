package com.msba.springbootmoviebookingapplication2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theatres")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;
    @Column(nullable = false)
    private String theatreName;
    @Column(nullable = false)
    private String theatreCity;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "theatreId", cascade = CascadeType.ALL)
    private Set<Screen> screens = new HashSet<>();;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "theatreId", cascade = CascadeType.ALL)
    private Set<Screening> screenings = new HashSet<>();;
}

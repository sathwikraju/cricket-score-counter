package com.cricket.csc.model;

import com.cricket.csc.model.enums.MatchStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Team team1;

    @ManyToOne
    private Team team2;

    private LocalDate date;
    private String location;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<Innings> innings;
}

package com.cricket.csc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Innings")
public class Innings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Match match;
    @ManyToOne
    private Team battingTeam;
    @ManyToOne
    private Team bowlingTeam;
    private Integer runs;
    private Integer wickets;
    private Double overs;

    @OneToMany(mappedBy = "innings", cascade = CascadeType.ALL)
    private List<Ball> balls;
}

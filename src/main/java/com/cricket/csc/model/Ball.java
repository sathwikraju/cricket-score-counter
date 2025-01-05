package com.cricket.csc.model;

import com.cricket.csc.model.enums.BallType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "balls")
public class Ball {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Innings innings;
    @ManyToOne
    private Player batsman;
    @ManyToOne
    private Player bowler;

    private Integer run;

    @Enumerated(EnumType.STRING)
    private BallType ballType;

    private Boolean isWicket;
}

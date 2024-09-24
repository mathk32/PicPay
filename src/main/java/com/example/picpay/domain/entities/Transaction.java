package com.example.picpay.domain.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotNull
    @JoinColumn(name = "userpaye_id")
    @ManyToOne
    private User paye;

    @NotNull
    @JoinColumn(name = "userpayee_id")
    @ManyToOne
    private User payee;

    private BigDecimal value;


    private LocalDate data;

}

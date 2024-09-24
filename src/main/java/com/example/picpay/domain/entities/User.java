package com.example.picpay.domain.entities;


import com.example.picpay.domain.entities.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "{campo.nome-user.obrigatorio}")
    private String nome;
    @CPF(message = "{campo.cpf-user.valido}")
    @NotEmpty(message = "{campo.cpf-user.obrigatorio}")
    @Column(unique = true)
    private String cpf;
    @Email(message = "{campo.email-user.valido}")
    @NotEmpty(message = "{campo.email-user.obrigatorio}" )
    @Column(unique = true)
    private String email;
    @NotEmpty(message = "{campo.senha-user.obrigatorio}")
    private String senha;

    @Enumerated(EnumType.STRING)
    private UserType tipo;


}

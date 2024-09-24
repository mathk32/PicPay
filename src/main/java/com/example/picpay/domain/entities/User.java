package com.example.picpay.domain.entities;


import com.example.picpay.domain.entities.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

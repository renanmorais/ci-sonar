package com.cisonar.domain.pessoa;

import com.sun.istack.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private String cpf;

    @NotNull
    @Column(name = "data_nascimento")
    private Date dataNascimento;

}
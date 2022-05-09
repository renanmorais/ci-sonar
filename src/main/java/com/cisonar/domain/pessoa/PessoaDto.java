package com.cisonar.domain.pessoa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class PessoaDto {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private Date dataNascimento;

    public Pessoa adaptPessoaDto() {
        return new Pessoa(getId(),
                getNome(),
                getEmail(),
                getCpf(),
                getDataNascimento());
    }

}
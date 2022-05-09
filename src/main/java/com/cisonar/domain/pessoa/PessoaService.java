package com.cisonar.domain.pessoa;

import com.cisonar.helper.ValidadorCpf;
import com.cisonar.helper.ValidadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import javax.management.RuntimeErrorException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPeloId(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa criar(PessoaDto pessoaDto) throws Exception {
        Date dataAtual = new Date();

        if (pessoaDto.getDataNascimento().after(dataAtual)) {
            throw new RuntimeErrorException(new Error("Nâo foi possível salvar, data de nascimento maior que a data atual."));
        }

        if (!ValidadorCpf.isCPF(pessoaDto.getCpf())) {
            throw new RuntimeErrorException(new Error("Nâo foi possível salvar, CPF inválido."));
        }

        if (!ValidadorEmail.isEmail(pessoaDto.getEmail())) {
            throw new RuntimeErrorException(new Error("Nâo foi possível salvar, E-mail inválido."));
        }

        return pessoaRepository.save(pessoaDto.adaptPessoaDto());
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}

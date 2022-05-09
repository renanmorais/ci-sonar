package com.cisonar.domain.pessoa;

import com.cisonar.helper.ValidadorCpf;
import com.cisonar.helper.ValidadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Pessoa criar(Pessoa pessoa) throws Exception {
        Date dataAtual = new Date();

        if (pessoa.getDataNascimento().after(dataAtual)) {
            throw new Exception("Nâo foi possível salvar, data de nascimento maior que a data atual.");
        }

        if(!ValidadorCpf.isCPF(pessoa.getCpf())) {
            throw new Exception("Nâo foi possível salvar, CPF inválido.");
        }

        if(!ValidadorEmail.isEmail(pessoa.getEmail())) {
            throw new Exception("Nâo foi possível salvar, E-mail inválido.");
        }

        return pessoaRepository.save(pessoa);
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}

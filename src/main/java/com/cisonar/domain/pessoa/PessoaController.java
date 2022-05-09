package com.cisonar.domain.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>>  BuscarTodos() {
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> BuscarPeloId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.buscarPeloId(id);
        return pessoa.isPresent() ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Pessoa> Criar(@RequestBody Pessoa pessoa) {
        try {
            return ResponseEntity.ok(pessoaService.criar(pessoa));
        } catch (Exception e) {
            var headers = new HttpHeaders();
            headers.add("message", e.getMessage());
            return ResponseEntity.badRequest().headers(headers).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.delete(id);
    }

}
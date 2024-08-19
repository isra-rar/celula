package com.ekballo.celula.service.impl;

import com.ekballo.celula.exceptions.ResourceNotFoundException;
import com.ekballo.celula.model.Pessoa;
import com.ekballo.celula.repositories.PessoaRepository;
import com.ekballo.celula.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    @Override
    public Pessoa getPessoaById(long idPessoa) {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));
    }
}

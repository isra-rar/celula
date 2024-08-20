package com.ekballo.celula.service.impl;

import com.ekballo.celula.model.Contribuicao;
import com.ekballo.celula.repositories.ContribuicaoRepository;
import com.ekballo.celula.service.ContribuicaoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ContribuicaoServiceImpl implements ContribuicaoService {

    private final ContribuicaoRepository contribuicaoRepository;

    @Override
    public Contribuicao createContribuicao(@NonNull Contribuicao contribuicao) {
        return contribuicaoRepository.save(contribuicao);
    }
}

package com.ekballo.celula.service.impl;

import com.ekballo.celula.exceptions.ResourceNotFoundException;
import com.ekballo.celula.model.Celula;
import com.ekballo.celula.repositories.CelulaRepository;
import com.ekballo.celula.service.CelulaService;
import com.ekballo.celula.service.PessoaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CelulaServiceImpl implements CelulaService {

    private final CelulaRepository celulaRepository;
    private final PessoaService pessoaService;

    @Override
    public Celula createCelula(@NonNull Celula celula) {
        return celulaRepository.save(celula);
    }

    @Override
    public void updateCelula(long idCelula, @NonNull Celula celula) {
        celula.setId(findCelulaById(idCelula).getId());
        celulaRepository.save(celula);
    }

    @Override
    public void deleteCelula(long idCelula) {
        celulaRepository.delete(findCelulaById(idCelula));
    }

    @Override
    public void addPessoaCelula(long idCelula, long idPessoa) {
        Celula celula = findCelulaById(idCelula);
        celula.adicionarPessoaCelula(pessoaService.getPessoaById(idPessoa));
        celulaRepository.save(celula);
    }

    private Celula findCelulaById(long idCelula) {
        return celulaRepository.findById(idCelula)
                .orElseThrow(() -> new ResourceNotFoundException("Celula não encontrada"));
    }
}

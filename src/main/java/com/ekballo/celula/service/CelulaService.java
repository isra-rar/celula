package com.ekballo.celula.service;

import com.ekballo.celula.model.Celula;

public interface CelulaService {

    Celula createCelula(Celula celula);
    void updateCelula(long idCelula, Celula celula);
    void deleteCelula(long idCelula);
    void addPessoaCelula(long idCelula ,long idPessoa);
}

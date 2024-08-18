package com.ekballo.celula.util;

import com.ekballo.celula.model.Celula;
import com.ekballo.celula.model.Igreja;
import com.ekballo.celula.model.Pessoa;
import com.ekballo.celula.repositories.CelulaRepository;
import com.ekballo.celula.repositories.IgrejaRepository;
import com.ekballo.celula.repositories.PessoaRepository;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Component
public class DataInitialization implements CommandLineRunner {

    private final IgrejaRepository igrejaRepository;
    private final CelulaRepository celulaRepository;
    private final PessoaRepository pessoaRepository;
    private final Faker faker;

    public DataInitialization(IgrejaRepository igrejaRepository,
                              CelulaRepository celulaRepository,
                              PessoaRepository pessoaRepository) {
        this.igrejaRepository = igrejaRepository;
        this.celulaRepository = celulaRepository;
        this.pessoaRepository = pessoaRepository;
        this.faker = new Faker(new Locale("pt", "BR"));
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (igrejaRepository.count() == 0 && celulaRepository.count() == 0 && pessoaRepository.count() == 0) {
            // Criar uma única Igreja
            Igreja igreja = new Igreja();
            igreja.setNome("Batista Farol");
            igrejaRepository.save(igreja);

            // Criar duas Células associadas à Igreja
            List<Celula> celulas = new ArrayList<>();

            Celula celula1 = new Celula();
            celula1.setNome("Célula Bancarios");
            celula1.setIgreja(igreja);
            celulaRepository.save(celula1);

            Celula celula2 = new Celula();
            celula2.setNome("Célula Cabo Branco");
            celula2.setIgreja(igreja);
            celulaRepository.save(celula2);
            Collections.addAll(celulas, celula1, celula2);


            // Criar 10 Pessoas em cada Célula
            for (Celula celula : celulas) {
                for (int i = 1; i <= 10; i++) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome(faker.name().fullName());
                    pessoa.setTelefone(faker.phoneNumber().cellPhone());
                    pessoa.setHasCelula(true);
                    pessoa.setCelula(celula);
                    pessoaRepository.save(pessoa);
                }
            }

            System.out.println("Dados iniciais criados com sucesso!");
        } else System.out.println("Já existem dados criados!");

    }
}

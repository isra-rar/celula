package com.ekballo.celula.util;

import com.ekballo.celula.model.Celula;
import com.ekballo.celula.model.Endereco;
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

            Celula celula1 = Celula.builder()
                    .nome("Célula Bancarios")
                    .igreja(igreja)
                    .endereco(generateFakeEndereco())
                    .build();
            celulaRepository.save(celula1);

            Celula celula2 = Celula.builder()
                    .nome("Célula Cabo Branco")
                    .igreja(igreja)
                    .endereco(generateFakeEndereco())
                    .build();
            celulaRepository.save(celula2);

            Collections.addAll(celulas, celula1, celula2);

            // Criar 10 Pessoas em cada Célula
            for (Celula celula : celulas) {
                for (int i = 1; i <= 10; i++) {
                    Pessoa pessoa = Pessoa.builder()
                            .nome(faker.name().fullName())
                            .telefone(faker.phoneNumber().cellPhone())
                            .endereco(generateFakeEndereco())
                            .hasCelula(true)
                            .celula(celula)
                            .build();
                    pessoaRepository.save(pessoa);
                }
            }

            System.out.println("Dados iniciais criados com sucesso!");
        } else {
            System.out.println("Já existem dados criados!");
        }
    }

    private Endereco generateFakeEndereco() {
        return Endereco.builder()
                .rua(faker.address().streetName())
                .numero(faker.address().buildingNumber())
                .complemento(faker.address().secondaryAddress())
                .bairro(faker.address().cityName())
                .cidade(faker.address().city())
                .estado(faker.address().stateAbbr())
                .cep(faker.address().zipCode())
                .build();
    }
}

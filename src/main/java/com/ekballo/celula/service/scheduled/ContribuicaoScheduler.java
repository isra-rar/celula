package com.ekballo.celula.service.scheduled;

import com.ekballo.celula.model.Celula;
import com.ekballo.celula.model.Contribuicao;
import com.ekballo.celula.model.enums.DiaSemana;
import com.ekballo.celula.repositories.CelulaRepository;
import com.ekballo.celula.repositories.ContribuicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ContribuicaoScheduler {

    private final ContribuicaoRepository contribuicaoRepository;
    private final CelulaRepository celulaRepository;

    @Scheduled(cron = "0 0 10 * * *")
    public void criarContribuicaoParaCelulas() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DayOfWeek diaSemanaAmanha = tomorrow.getDayOfWeek();

        // Buscar todas as células que têm reunião no dia seguinte
        List<Celula> celulas = celulaRepository.findByDiaSemana(DiaSemana.fromDayOfWeek(diaSemanaAmanha));

        for (Celula celula : celulas) {
            LocalDateTime dataCelula = tomorrow.atTime(celula.getHorario());

            Contribuicao contribuicao = Contribuicao.builder()
                    .celula(celula)
                    .dataCelula(dataCelula)
                    .valorArrecadado(BigDecimal.ZERO)
                    .build();

            contribuicaoRepository.save(contribuicao);
        }

        System.out.println("Contribuições criadas para as células com reunião amanhã.");
    }
}

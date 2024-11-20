package br.com.projetaria.infrastructure.controllers.output;

import java.time.LocalDateTime;

public record TransacionarOutput(
        String transactionId,
        LocalDateTime transactionAt
) {
}

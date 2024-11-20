package br.com.projetaria.application.usecase.output;

import java.time.LocalDateTime;

public record TransactionCommandOutput(
        String transactionId,
        LocalDateTime transactionAt
) {
}

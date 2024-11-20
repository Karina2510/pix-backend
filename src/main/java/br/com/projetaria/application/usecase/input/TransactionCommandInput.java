package br.com.projetaria.application.usecase.input;

import java.math.BigDecimal;

public record TransactionCommandInput(
        String requesterUserId,
        String receiverUserId,
        BigDecimal amount
) {
}

package br.com.projetaria.infrastructure.controllers.input;

import java.math.BigDecimal;

public record TransactInput(
        String requesterUserId,
        String receiverUserId,
        BigDecimal amount
) {
}

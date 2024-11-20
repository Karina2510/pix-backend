package br.com.projetaria.infrastructure.accountservice.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountOutput(String id, String userId, BigDecimal balance, LocalDateTime createdAt) {
}

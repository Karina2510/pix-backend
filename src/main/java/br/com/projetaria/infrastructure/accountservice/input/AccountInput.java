package br.com.projetaria.infrastructure.accountservice.input;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountInput(String id, String userId, BigDecimal balance, LocalDateTime createdAt) {
}

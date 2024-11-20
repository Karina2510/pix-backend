package br.com.projetaria.infrastructure.userserver.output;

import java.time.LocalDateTime;

public record UserOutput(String id, String name, LocalDateTime createdAt) {
}

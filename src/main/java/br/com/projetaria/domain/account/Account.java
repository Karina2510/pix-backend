package br.com.projetaria.domain.account;

import br.com.projetaria.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {

    private String id;

    private User user;

    private BigDecimal balance;

    private LocalDateTime createdAt;

    public Account(
            final String id,
            final User user,
            final BigDecimal balance,
            final LocalDateTime createdAt) {

        this.id        = id;
        this.user      = user;
        this.balance   = balance;
        this.createdAt = createdAt;

        this.validate();
    }

    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void debit(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void validate() {
        if (id == null) {
            throw new RuntimeException("ID is required");
        }

        if (user == null) {
            throw new RuntimeException("User is required");
        }

        if (balance == null) {
            throw new RuntimeException("Balance is required");
        }
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

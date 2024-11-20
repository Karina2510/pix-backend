package br.com.projetaria.domain.transaction;

import br.com.projetaria.domain.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private String id;

    private Account accountToDebit;

    private Account accountToCredit;

    private BigDecimal amount;

    private LocalDateTime transactionAt;

    private Transaction(
            final Account accountToDebit,
            final Account accountToCredit,
            final BigDecimal amount) {

        this.id = UUID.randomUUID().toString();
        this.accountToDebit = accountToDebit;
        this.accountToCredit = accountToCredit;
        this.amount = amount;
        this.transactionAt = LocalDateTime.now();
    }

    public static Transaction doTransaction(
            final Account accountToDebit,
            final Account accountToCredit,
            final BigDecimal amount) {

        final Transaction transaction = new Transaction(
            accountToDebit,
            accountToCredit,
            amount
        );

        transaction.getAccountToDebit().debit(transaction.getAmount());
        transaction.getAccountToCredit().credit(transaction.getAmount());

        return transaction;
    }

    public String getId() {
        return this.id;
    }

    public Account getAccountToDebit() {
        return accountToDebit;
    }

    public Account getAccountToCredit() {
        return accountToCredit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionAt() {
        return this.transactionAt;
    }
}

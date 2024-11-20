package br.com.projetaria.domain.transaction.repository;

import br.com.projetaria.domain.transaction.Transaction;

public interface ITransactionRepository {

    void save(final Transaction transaction);
}

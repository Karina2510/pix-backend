package br.com.projetaria.infrastructure.repository;

import br.com.projetaria.domain.transaction.Transaction;
import br.com.projetaria.domain.transaction.repository.ITransactionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository implements ITransactionRepository {

    @Override
    public void save(Transaction transaction) {
        System.out.println("Salvando no banco de dados");
    }
}

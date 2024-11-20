package br.com.projetaria.application.usecase;

import br.com.projetaria.application.usecase.input.TransactionCommandInput;
import br.com.projetaria.application.usecase.output.TransactionCommandOutput;
import br.com.projetaria.domain.account.Account;
import br.com.projetaria.domain.account.service.IAccountService;
import br.com.projetaria.domain.transaction.Transaction;
import br.com.projetaria.domain.transaction.repository.ITransactionRepository;
import br.com.projetaria.domain.user.User;
import br.com.projetaria.domain.user.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class TransactByAccountsUseCase {

    private final IUserService userService;

    private final IAccountService accountService;

    private final ITransactionRepository transactionRepository;

    public TransactByAccountsUseCase(
            final IUserService userService,
            final IAccountService accountService,
            final ITransactionRepository transactionRepository) {
        this.userService           = userService;
        this.accountService        = accountService;
        this.transactionRepository = transactionRepository;
    }

    public TransactionCommandOutput execute(final TransactionCommandInput commandInput) {

        final User userRequester = this.userService.getUserBy(commandInput.requesterUserId());
        final User userReceiver  = this.userService.getUserBy(commandInput.receiverUserId());

        final Account accountToDebit  = this.accountService.getAccountBy(userRequester);
        final Account accountToCredit = this.accountService.getAccountBy(userReceiver);

        final Transaction transaction = Transaction.doTransaction(
                accountToDebit,
                accountToCredit,
                commandInput.amount());

        this.accountService.updateBalance(accountToDebit);
        this.accountService.updateBalance(accountToCredit);

        this.transactionRepository.save(transaction);

        return new TransactionCommandOutput(transaction.getId(), transaction.getTransactionAt());
    }
}

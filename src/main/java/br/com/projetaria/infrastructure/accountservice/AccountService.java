package br.com.projetaria.infrastructure.accountservice;

import br.com.projetaria.domain.account.Account;
import br.com.projetaria.domain.account.service.IAccountService;
import br.com.projetaria.domain.user.User;
import br.com.projetaria.infrastructure.accountservice.input.AccountInput;
import br.com.projetaria.infrastructure.accountservice.output.AccountOutput;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    private final AccountClient userClient;

    public AccountService(AccountClient userClient) {
        this.userClient = userClient;
    }


    @Override
    public Account getAccountBy(User user) {

        final AccountOutput accountFounded = this.userClient.getAccountBy(user.getId()).get(0);

        return new Account(
                accountFounded.id(),
                user,
                accountFounded.balance(),
                accountFounded.createdAt()
        );
    }

    @Override
    public void updateBalance(Account account) {
        final AccountInput input = new AccountInput(
                account.getId(),
                account.getUser().getId(),
                account.getBalance(),
                account.getCreatedAt()
        );
        userClient.updateAccount(account.getId(), input);
    }
}

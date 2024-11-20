package br.com.projetaria.domain.account.service;

import br.com.projetaria.domain.account.Account;
import br.com.projetaria.domain.user.User;

public interface IAccountService {

    Account getAccountBy(final User user);

    void updateBalance(final Account account);
}

package tutorial.core.services;

import tutorial.core.models.entities.Account;
import tutorial.core.services.util.AccountList;


public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}

package tutorial.core.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tutorial.core.models.entities.Account;

public class AccountRepoUnitTest {

    @Mock
    private AccountRepo repo;

    private Account account;

    @Before
    public void setup()
    {
    	
    	MockitoAnnotations.initMocks(this);
        account = new Account();
        account.setId(2l);
        account.setName("sarang");
        account.setPassword("sarang");
       
    }

    @Test
    public void shouldReturn_accountForGivenAccountId()
    {
    	when(repo.findAccount(this.account.getId())).thenReturn(account);
        Account account = repo.findAccount(this.account.getId());
        assertNotNull(account);
    }
    
    
    @Test
    public void shouldReturn_accountForGivenName()
    {
    	when(repo.findAccountByName(this.account.getName())).thenReturn(account);
    	Account account = repo.findAccountByName("sarang");
    	assertEquals(account.getName(), "sarang");
    }
    
    @Test
    public void shouldreturn_null_when_accountWithGivenNameNotPresent(){
    	when(repo.findAccountByName("XYZ")).thenReturn(null);
    	Account account = repo.findAccountByName("Sarang1");
    	assertNull(account);	
    }
    
    @Test
    public void shouldreturn_null_when_accountWithGivenIdNotPresent(){
    	when(repo.findAccount(1l)).thenReturn(null);
    	Account account = repo.findAccount(1l);
    	assertNull(account);	
    }
    
    
    @Test
    public void shouldreturn_createdAccount_when_accountIsCreated(){
    	when(repo.createAccount(this.account)).thenReturn(this.account);
    	Account account = repo.createAccount(this.account);
    	assertNotNull(account);
    	
    }
    
}

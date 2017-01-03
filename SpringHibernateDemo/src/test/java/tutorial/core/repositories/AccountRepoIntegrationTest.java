package tutorial.core.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import tutorial.core.models.entities.Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class AccountRepoIntegrationTest {

    @Autowired
    private AccountRepo repo;

    private Account account;

    @Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
        account = new Account();
        account.setId(2l);
        account.setName("sarang");
        account.setPassword("sarang");
       // repo.createAccount(account);
    }

    @Test
    @Transactional
    public void testFind()
    {
        Account account = repo.findAccount(this.account.getId());
        assertNotNull(account);
        assertEquals(account.getName(), "sarang");
        assertEquals(account.getPassword(), "sarang");
    }
    
    
    @Test
    public void testFindAccountByName()
    {
    	Account account = repo.findAccountByName("sarang1");
    	assertEquals(account.getName(), "sarang");
    }
}

package bank.abc.maven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for BankAccount.java.
 */
public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("123456", "John Doe");  // initial setup
    }

    @Test
    public void testAccountCreation() {
        assertEquals("123456", account.getAccountNumber());
        assertEquals("John Doe", account.getAccountHolderName());
        assertEquals(0, account.getBalance(), 0.01);
    }

    @Test
    public void testDeposit() {
        account.deposit(200.0);
        assertEquals(200.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        account.deposit(500.0);
        account.withdraw(100.0);
        assertEquals(400.0, account.getBalance(), 0.01);
    }

    // @Test for later invalidDeposit case
    // public void testInvalidDeposit() {
    //     try {
    //         account.deposit(50.0);
    //         fail("Expected IllegalArgumentException for negative deposit");
    //     } catch (IllegalArgumentException e) {
    //         // expected exception
    //     }
    // }

    // @Test for later WithdrawMoreThanBalance case
    // public void testWithdrawMoreThanBalance() {
    //     try {
    //         account.withdraw(600.0); // Withdraw more than the balance
    //         fail("Expected IllegalArgumentException for overdraw");
    //     } catch (IllegalArgumentException e) {
    //         // expected exception
    //     }
    // }

    @Test
    public void testGetBalance() {
        account.deposit(500.0);
        assertEquals(500.0, account.getBalance(), 0.01);
    }
    
    
}

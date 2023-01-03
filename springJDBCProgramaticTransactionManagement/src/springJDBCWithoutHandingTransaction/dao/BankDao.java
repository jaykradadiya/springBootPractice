package springJDBCWithoutHandingTransaction.dao;

import springJDBCWithoutHandingTransaction.dao.exception.InsuffiecientAccountBalanceException;
import springJDBCWithoutHandingTransaction.model.Account;

public interface BankDao {
	

	public abstract void withdrow(Account fromAccount,Account toAccount,double amount) throws InsuffiecientAccountBalanceException;
	public abstract void deposit(Account fromAccount,Account toAccount,double amount);

}

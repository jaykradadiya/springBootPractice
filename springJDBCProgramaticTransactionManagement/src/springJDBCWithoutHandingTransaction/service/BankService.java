package springJDBCWithoutHandingTransaction.service;

import springJDBCWithoutHandingTransaction.dao.exception.InsuffiecientAccountBalanceException;
import springJDBCWithoutHandingTransaction.model.Account;

public interface BankService {
	public abstract void transferFund(Account fromAccount,Account toAccount,double amount) throws InsuffiecientAccountBalanceException;

}

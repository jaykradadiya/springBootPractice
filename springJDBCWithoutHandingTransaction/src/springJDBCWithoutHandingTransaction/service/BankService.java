package springJDBCWithoutHandingTransaction.service;

import springJDBCWithoutHandingTransaction.model.Account;

public interface BankService {
	public abstract void transferFund(Account fromAccount,Account toAccount,double amount);

}

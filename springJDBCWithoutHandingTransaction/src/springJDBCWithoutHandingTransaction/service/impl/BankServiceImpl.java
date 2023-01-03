package springJDBCWithoutHandingTransaction.service.impl;

import springJDBCWithoutHandingTransaction.dao.BankDao;
import springJDBCWithoutHandingTransaction.dao.exception.InsuffiecientAccountBalanceException;
import springJDBCWithoutHandingTransaction.model.Account;
import springJDBCWithoutHandingTransaction.service.BankService;

public class BankServiceImpl implements BankService {

	private BankDao bankDao;

	public BankDao getBankDao() {
		return bankDao;
	}

	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}

	@Override
	public void transferFund(Account fromAccount, Account toAccount, double amount) {

		try {
			getBankDao().withdrow(fromAccount, toAccount, amount);
			getBankDao().deposit(fromAccount, toAccount, amount);
		} catch (InsuffiecientAccountBalanceException e) {
			System.out.println(e.getMessage());
		}
	}

}

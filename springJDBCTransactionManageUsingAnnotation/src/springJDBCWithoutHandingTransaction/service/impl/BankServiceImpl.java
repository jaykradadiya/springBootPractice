package springJDBCWithoutHandingTransaction.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import springJDBCWithoutHandingTransaction.dao.BankDao;
import springJDBCWithoutHandingTransaction.dao.exception.InsuffiecientAccountBalanceException;
import springJDBCWithoutHandingTransaction.model.Account;
import springJDBCWithoutHandingTransaction.service.BankService;

public class BankServiceImpl implements BankService {

	private BankDao bankDao;
	private TransactionTemplate transactionTemplate;

	public BankDao getBankDao() {
		return bankDao;
	}

	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
	

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void transferFund(Account fromAccount, Account toAccount, double amount) {

		transactionTemplate.execute(new TransactionCallback<Void>() {

			@Override
			public Void doInTransaction(TransactionStatus arg0) {
				try {
					getBankDao().withdrow(fromAccount, toAccount, amount);
					getBankDao().deposit(fromAccount, toAccount, amount);
				} catch (InsuffiecientAccountBalanceException e) {
					System.out.println(e.getMessage());
				}
				return null;
			}
			
		});

	}
	
//	@Override
//	public void transferFund(Account fromAccount, Account toAccount, double amount) {
//
//		try {
//			getBankDao().withdrow(fromAccount, toAccount, amount);
//			getBankDao().deposit(fromAccount, toAccount, amount);
//		} catch (InsuffiecientAccountBalanceException e) {
//			System.out.println(e.getMessage());
//		}
//	}

}

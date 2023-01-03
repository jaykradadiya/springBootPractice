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
//<tx:annotation-driven	transaction-manager="transactionManager" proxy-target-class="true" />
//	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false,timeout = 100,rollbackFor = Exception.class)
	public void transferFund(Account fromAccount, Account toAccount, double amount) throws InsuffiecientAccountBalanceException {
		getBankDao().withdrow(fromAccount, toAccount, amount);
		getBankDao().deposit(fromAccount, toAccount, amount);

	}

//	@Override
//	public void transferFund(Account fromAccount, Account toAccount, double amount) {
//
//		transactionTemplate.execute(new TransactionCallback<Void>() {
//
//			@Override
//			public Void doInTransaction(TransactionStatus arg0) {
//				try {
//					getBankDao().withdrow(fromAccount, toAccount, amount);
//					getBankDao().deposit(fromAccount, toAccount, amount);
//				} catch (InsuffiecientAccountBalanceException e) {
//					System.out.println(e.getMessage());
//				}
//				return null;
//			}
//			
//		});
//
//	}

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

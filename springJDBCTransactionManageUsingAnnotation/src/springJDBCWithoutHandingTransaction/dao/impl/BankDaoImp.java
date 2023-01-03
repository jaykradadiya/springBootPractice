package springJDBCWithoutHandingTransaction.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import springJDBCWithoutHandingTransaction.dao.BankDao;
import springJDBCWithoutHandingTransaction.dao.exception.InsuffiecientAccountBalanceException;
import springJDBCWithoutHandingTransaction.dao.mapper.AccountRowMapper;
import springJDBCWithoutHandingTransaction.model.Account;

public class BankDaoImp implements BankDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void withdrow(Account fromAccount, Account toAccount, double amount)
			throws InsuffiecientAccountBalanceException {
		// TODO Auto-generated method stub

		Account accountFromDb = getAccountFromDB(fromAccount.getAccountNumber());

		Double accountBalance = accountFromDb.getAccountBalance() - amount;

		if (accountFromDb.getAccountBalance() >= amount) {

		} else {
			throw new InsuffiecientAccountBalanceException("Insufficient Account Balance");
		}

		String SQL = "Update bank set account_balance=? WHERE account_no=?";

		int update = getJdbcTemplate().update(SQL, accountBalance, fromAccount.getAccountNumber());

		if (update > 0) {
			System.out.println("Amount Rs: " + amount + " is transferred from account No: "
					+ fromAccount.getAccountNumber() + " to account NO: " + toAccount.getAccountNumber());
		}

	}

	@Override
	public void deposit(Account fromAccount, Account toAccount, double amount) {
		// TODO Auto-generated method stub
		Account accountFromDb = getAccountFromDB(toAccount.getAccountNumber());

		Double accountBalance = accountFromDb.getAccountBalance() + amount;

		String SQL = "Update bank set account_balance=? WHERE account_no=?";

		int update = getJdbcTemplate().update(SQL, accountBalance, toAccount.getAccountNumber());

		if (update > 0) {
			System.out.println("Amount Rs: " + amount + " is Deposit to account No: " + toAccount.getAccountNumber());
		}
		throw new RuntimeException();
	}

	private Account getAccountFromDB(Long accountNumber) {
		String sql = "Select * from bank where account_no = ?";

		Account account = getJdbcTemplate().queryForObject(sql, new AccountRowMapper(), accountNumber);
		return account;
	}

}

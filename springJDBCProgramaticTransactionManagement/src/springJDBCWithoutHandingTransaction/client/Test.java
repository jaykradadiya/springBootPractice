package springJDBCWithoutHandingTransaction.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springJDBCWithoutHandingTransaction.dao.exception.InsuffiecientAccountBalanceException;
import springJDBCWithoutHandingTransaction.model.Account;
import springJDBCWithoutHandingTransaction.service.BankService;
import springJDBCWithoutHandingTransaction.service.impl.BankServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		
		BankService bankService= ctx.getBean("bankService",BankServiceImpl.class);
		
		Account fromAccount = new Account();
		fromAccount.setAccountNumber(1122330056L);
		
		Account toAccount = new Account();
		toAccount.setAccountNumber(3355330099L);
		
		try {
			bankService.transferFund(fromAccount, toAccount, 1000);
		} catch (InsuffiecientAccountBalanceException e) {
			e.printStackTrace();
		}
		
		ctx.close();
	}

}

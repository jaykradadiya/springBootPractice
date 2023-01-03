package springJDBCWithoutHandingTransaction.dao.exception;

public class InsuffiecientAccountBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647500382132314811L;

	
	public InsuffiecientAccountBalanceException(String message) {
		super(message);
	}
}

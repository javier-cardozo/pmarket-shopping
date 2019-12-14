package uy.org.pmarket.shopping.exception;

public class ShoppingException extends Exception {

	private static final long serialVersionUID = 7598266122376236788L;

	public ShoppingException(Exception e) {
		super(e);
	}
	
	public ShoppingException(String message) {
		super(message);
	}
}

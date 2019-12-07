package uy.org.pmarket.shopping.exception;

public class ShoppingMissingException extends Exception {

	private static final long serialVersionUID = 7598266122376236788L;

	public ShoppingMissingException(Exception e) {
		super(e);
	}
}

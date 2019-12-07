package uy.org.pmarket.shopping.repository;

public class RepositoryException extends RuntimeException {

    private static final long serialVersionUID = -6047353814745795789L;


    public RepositoryException() {
        super();
    }

    public RepositoryException(String message) {
        super(message);
    }


    public RepositoryException(String message, Exception e) {
        super(message,e);
    }

}
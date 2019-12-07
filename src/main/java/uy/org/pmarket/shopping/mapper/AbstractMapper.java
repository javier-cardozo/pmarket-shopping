package uy.org.pmarket.shopping.mapper;

public abstract class AbstractMapper<T,S> {
	
	public abstract T mapToEntity(S s);
	
	public abstract S mapToDTO(T t);
}

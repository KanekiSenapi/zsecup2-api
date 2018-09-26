package pl.aogiri.mobile.token;

import org.springframework.data.repository.CrudRepository;

public interface TokenReposiotory extends CrudRepository<Token, Long> {

	public Token findByToken(String token) throws NullPointerException;
	
}

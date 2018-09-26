package pl.aogiri.mobile.token;

import java.security.SecureRandom;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import security.Decryption;



@Service
public class TokenService {
	
	@Autowired
	TokenReposiotory tokenRepository;
	
	public Token getTokenById(long id) {
		return tokenRepository.findById(id).get();
	}
	
	public long getUserIdByToken(String tokenValue) {
		Token token = tokenRepository.findByToken(tokenValue);
		if(token.getStatus()==1) {
			return token.getUserId();
		}
		return 0L;
	}
	
	public int newToken(Map<String, String> mapped) {
		Token token = new Token();
		token.setToken(this.createRandomCode(35));
		token.setName(mapped.get("name"));
		token.setStatus(0);
		token.setUserId(Long.parseLong(mapped.get("id")));
		
		try {
			tokenRepository.save(token);
		}
		catch(Exception e) {
			return 0;
		}
		return (int) token.getId();		
	}	
	public String createRandomCode(int codeLength) {
		String id = "!#$%&()*+,-.:;<=>?@[]^_{|}~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
	    return new SecureRandom()
	            .ints(codeLength, 0, id.length())
	            .mapToObj(id::charAt)
	            .map(Object::toString)
	            .collect(Collectors.joining());
	}
	
	@SuppressWarnings("null")
	public String checkQrCode(Map<String, String> mapped) {
		String name = mapped.get("name");
		String token_lock = mapped.get("token");
		String token_unlocked;
		Token token = null; 
		
		try {
			Decryption de = new Decryption();
			token_unlocked = de.decrypt(token_lock);
		}
		catch(Exception e) {
			return "700";
		}
		
		try {
			token = tokenRepository.findByToken(token_unlocked);
		}
		catch(Exception e){
			return "702";
		}
		
		if(token.getStatus()!=0) {
			return "701";
		}
		
		token.setStatus(1);
		
		try{
			token.setName(name);
			tokenRepository.save(token);
		}
		catch(Exception e) {
			return "703";
		}
		
		return token_unlocked;
	}

	public int checkToken(Map<String, String> mapped) {
		String token_unlocked = mapped.get("token");
		Token token = null; 
		
		
		token = tokenRepository.findByToken(token_unlocked);
		if(token == null) {
			return 702;
		}

		
		if(token.getStatus()==0) {
			return 705;
		}
		
		
		
		return 1;
	}
	

}

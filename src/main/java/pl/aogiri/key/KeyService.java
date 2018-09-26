package pl.aogiri.key;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
	
	@Autowired
	KeyRepository keyRepository;

	public boolean checkKey(String value) {		
		return !keyRepository.findByValue(value).equals(null);
	}

	public SecretKey generateKey() {
		try {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256);
		SecretKey secretKey = keyGen.generateKey();
		Key toSave = new Key();
		toSave.setValue(secretKey.getEncoded().toString());
		keyRepository.save(toSave);
		return secretKey;    
		}
		catch(Exception ex) {
			return null;
		}
	}
	


}

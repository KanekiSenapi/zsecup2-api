package pl.aogiri.key;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {
	
	private static String apiKeyAccess = "IbrahimDezyderiuszIII";
	
	@Autowired
	KeyService keyService;
	
	
	public boolean checkKey(String value) {
		return keyService.checkKey(value);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/key/{aKA}")
	public SecretKey generateKey(@PathVariable String aKA) {
		if(apiKeyAccess.equals(aKA)) {
			return keyService.generateKey();
		}
		else return null;
	}

}

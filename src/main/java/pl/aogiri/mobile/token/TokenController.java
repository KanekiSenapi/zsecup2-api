package pl.aogiri.mobile.token;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import security.Encryption;
import security.QrCode;



@RestController
public class TokenController {
	
	@Autowired
	TokenService tokenService;
	
	@RequestMapping(method = RequestMethod.POST, value="/api/token")
	public int newToken(@RequestBody Map<String, String> mapped ) {
		return tokenService.newToken(mapped);	
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/api/token/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getQrCode(@PathVariable long id) { 
		Token token = tokenService.getTokenById(id);
		Encryption en = new Encryption();
				
		QrCode qrCode = new QrCode();
		
		
		try {
			return qrCode.generate(en.encrypt(token.getToken())).toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/api/token")
	public Map<String, String> checkQrCode(@RequestBody Map<String, String> mapped){
		String returned = tokenService.checkQrCode(mapped);
		Map<String, String> toReturn = new HashMap<String, String>();
		toReturn.put("value", returned);
		return toReturn;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/api/token/check")
	public Map<String, String> checkToken(@RequestBody Map<String, String> mapped) {
		Map<String,String> toR = new HashMap<String,String>();
		toR.put("response", String.valueOf(tokenService.checkToken(mapped)));
		return toR;
	}
	

}

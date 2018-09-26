package pl.aogiri.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User getUserById(@PathVariable long id){
		return userService.getUserById(id);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/full")
	public FullUser getFullUser(@PathVariable long id) {
		return userService.getFullUser(id);		
	}
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/activate")
	public boolean activateUser(@PathVariable long id) {
		return userService.activateUser(id);		
	}
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/activated")
	public String checkActivation(@PathVariable long id) {
		return userService.activatedUser(id);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/api/user")
	public FullUser getFullUserByToken(@RequestBody Map<String, String> mapped) {
		User user = userService.getUserByToken(mapped);
		return this.getFullUser(user.getId());
	}
	
	
	

}

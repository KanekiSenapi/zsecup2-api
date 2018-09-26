package pl.aogiri.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findUserById(long id);
	
}

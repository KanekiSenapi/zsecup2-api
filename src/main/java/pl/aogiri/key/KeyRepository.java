package pl.aogiri.key;

import org.springframework.data.repository.CrudRepository;

public interface KeyRepository extends CrudRepository<Key, Long>{
	
	public Key findByValue(String value);

}

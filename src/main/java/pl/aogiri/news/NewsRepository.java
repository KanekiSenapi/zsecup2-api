package pl.aogiri.news;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Long> {
	
	List<News> findAllByOrderByIdDesc();

}

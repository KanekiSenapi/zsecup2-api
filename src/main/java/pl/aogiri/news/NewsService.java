package pl.aogiri.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
	
	@Autowired
	NewsRepository newsRepository;
	
	public List<News> getNews(){
		return (List<News>) newsRepository.findAllByOrderByIdDesc();
	}

}

package pl.aogiri.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@RequestMapping(method=RequestMethod.GET,value="/api/news")
	public List<News> getNews() {
		return newsService.getNews();
		
	}
	

}

package pl.aogiri.match;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {

	public List<Match> findByTeam1Id(long id);
	public List<Match> findByTeam2Id(long id);
	
	
}

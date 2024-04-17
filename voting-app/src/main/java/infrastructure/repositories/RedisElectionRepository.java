package infrastructure.repositories;

import java.util.List;

import org.jboss.logging.Logger;

import domain.Candidate;
import domain.Election;
import domain.ElectionRepository;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.sortedset.SortedSetCommands;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RedisElectionRepository implements ElectionRepository {

    private static final Logger LOGGER = Logger.getLogger(RedisElectionRepository.class);
    private static final String KEY = "election:";
    private final SortedSetCommands<String, String> sortedSetCommands;

    public RedisElectionRepository(RedisDataSource redisdataSource) {
        sortedSetCommands = redisdataSource.sortedSet(String.class, String.class);
    }

    @Override
    public Election findById(String id) {
        LOGGER.info("Retrieving election " + id + " from redis");

        List<Candidate> candidates = sortedSetCommands.zrange(KEY + id, 0, -1)
                .stream()
                .map(Candidate::new)
                .toList();

        return new Election(id, candidates);
    }
}
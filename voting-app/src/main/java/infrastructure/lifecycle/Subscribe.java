package infrastructure.lifecycle;

import infrastructure.repositories.RedisElectionRepository;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import org.jboss.logging.Logger;

import domain.Election;
import io.quarkus.runtime.Startup;

import javax.enterprise.context.ApplicationScoped;

@Startup
@ApplicationScoped
public class Subscribe {

    private static final org.jboss.logging.Logger LOGGER = Logger.getLogger(Subscribe.class);

    //Consulta funcionando de forma reativa - assíncrona
    public Subscribe(ReactiveRedisDataSource reactiveDataSource, RedisElectionRepository repository) {

        LOGGER.info("Startup: Subscribe");

        Multi<String> sub = reactiveDataSource.pubsub(String.class).subscribe("elections");

        sub.emitOn(Infrastructure.getDefaultWorkerPool()).subscribe().with(id -> {
            LOGGER.info("Election " + id + " received from subscription");
            Election election = repository.findById(id);
            LOGGER.info("Election " + election.id() + " starting");
        });
    }

    /* Usando RedisDataSource, a thread que deveria ser não bloqueante foi bloqueada ao fazer a consulta,
       pois a conexão com redis está síncrona
     */
//    public Subscribe(RedisDataSource redisDataSource, RedisElectionRepository repository) {
//        LOGGER.info("Startup: Subscribe");
//
//        redisDataSource.pubsub(String.class).subscribe("elections", id -> {
//            LOGGER.info("Election " + id + " received from subscription");
//            Election election = repository.findById(id);
//            LOGGER.info("Election " + election.id() + " starting");
//        });
//    }
}

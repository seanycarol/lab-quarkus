package infrastructure.repositories;

import domain.Election;
import domain.ElectionRepository;
import infrastructure.repositories.entities.ElectionCandidateEntity;
import infrastructure.repositories.entities.ElectionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class SQLElectionRepository implements ElectionRepository {
    private final EntityManager entityManager;

    public SQLElectionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void submit(Election election) {
        ElectionEntity electionEntity = ElectionEntity.fromDomain(election);

        entityManager.merge(electionEntity);

        election.votes()
                .entrySet()
                .stream()
                .map(entry -> ElectionCandidateEntity.fromDomain(election, entry.getKey(), entry.getValue()))
                .forEach(entityManager::merge);
                
    }
}

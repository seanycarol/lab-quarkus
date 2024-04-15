package infrastructure.repositories;

import domain.CandidateRepository;
import domain.CandidateRepositoryTest;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@QuarkusTest
class SQLCandidateRepositoryTest extends CandidateRepositoryTest {

    @Inject
    SQLCandidateRepository candidateRepository;

    @Inject
    EntityManager entityManager;

    @Override
    public CandidateRepository candidateRepository() {
        return candidateRepository;
    }

    @AfterEach
    @TestTransaction
    void tearDown() {
        entityManager.createNativeQuery("TRUNCATE TABLE candidates").executeUpdate();
    }
}
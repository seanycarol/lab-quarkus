package domain;

import domain.annotations.Principal;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import java.util.List;

@ApplicationScoped
public class ElectionService {
    private final CandidateService candidateService;
    private final Instance<ElectionRepository> electionRepositories;
    private final ElectionRepository electionRepository;

    public ElectionService(CandidateService candidateService, @Any Instance<ElectionRepository> electionRepositories, @Principal ElectionRepository electionRepository) {
        this.candidateService = candidateService;
        this.electionRepositories = electionRepositories;
        this.electionRepository = electionRepository;
    }

    public List<Election> findAll() {
        return electionRepository.findAll();
    }

    public void submit() {
        Election election = Election.create(candidateService.findAll());
        electionRepositories.forEach(electionRepository -> electionRepository.submit(election));
    }
}

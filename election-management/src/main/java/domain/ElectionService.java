package domain;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;

@ApplicationScoped
public class ElectionService {
    private final CandidateService candidateService;
    private final Instance<ElectionRepository> electionRepositories;

    public ElectionService(CandidateService candidateService, Instance<ElectionRepository> electionRepositories) {
        this.candidateService = candidateService;
        this.electionRepositories = electionRepositories;
    }

    public void submit() {
        Election election = Election.create(candidateService.findAll());
        electionRepositories.forEach(electionRepository -> electionRepository.submit(election));
    }
}

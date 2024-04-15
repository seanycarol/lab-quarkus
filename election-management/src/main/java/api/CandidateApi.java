package api;

import api.dto.in.CreateCandidate;
import api.dto.in.UpdateCandidate;
import api.dto.out.CandidateResponse;
import domain.Candidate;
import domain.CandidateService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CandidateApi {
    private final CandidateService candidateService;

    public CandidateApi(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    public void create(CreateCandidate dto) {
        candidateService.save(dto.toDomain());
    }

    public CandidateResponse update(String id, UpdateCandidate dto) {
        candidateService.save(dto.toDomain(id));
        Candidate candidate = candidateService.findById(id);

        return CandidateResponse.fromDomain(candidate);
    }

    public List<CandidateResponse> list() {
        return candidateService.findAll().stream().map(CandidateResponse::fromDomain).toList();
    }
}

package api;

import javax.enterprise.context.ApplicationScoped;

import api.dto.out.ElectionResponse;
import domain.ElectionService;

import java.util.List;

@ApplicationScoped
public class ElectionApi {

    private final ElectionService service;

    public ElectionApi(ElectionService service) {
        this.service = service;
    }

    public List<ElectionResponse> findAll() {
        return service.findAll().stream().map(ElectionResponse::fromDomain).toList();
    }

    public void vote(String electionId, String candidateId) {
        service.vote(electionId, candidateId);
    }
}

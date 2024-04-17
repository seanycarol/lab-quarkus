package api;

import api.dto.out.ElectionResponse;
import domain.ElectionService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ElectionApi {
    private final ElectionService electionService;

    public ElectionApi(ElectionService electionService) {
        this.electionService = electionService;
    }

    public void submit() {
        electionService.submit();
    }

    public List<ElectionResponse> findAll() {
        return  electionService.findAll()
                .stream()
                .map(ElectionResponse::fromDomain)
                .toList();
    }
}

package api.dto.out;

import java.util.List;

import domain.Candidate;

public record ElectionResponse(String id, List<String> candidates) {

    public static ElectionResponse fromDomain(domain.Election election) {
        return new ElectionResponse(election.id(), election.candidates().stream().map(Candidate::id).toList());
    }
}

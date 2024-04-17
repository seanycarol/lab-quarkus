package api.dto.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import domain.Election;

import java.util.List;
import java.util.Optional;

public record ElectionResponse(String id, List<Candidate> candidates) {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public record Candidate(String id,
                            Optional<String> photo,
                            String fullName,
                            String email,
                            Optional<String> phone,
                            Optional<String> jobTitle,
                            Integer votes) {
    }

    public static ElectionResponse fromDomain(Election election) {
        var candidates = election.votes()
                                .entrySet()
                                .stream()
                                .map(entry -> new Candidate(entry.getKey().id(),
                                    entry.getKey().photo(),
                                    entry.getKey().givenName() + " " + entry.getKey().familyName(),
                                    entry.getKey().email(),
                                    entry.getKey().phone(),
                                    entry.getKey().jobTitle(),
                                    entry.getValue()))
                                .toList();

        return new ElectionResponse(election.id(), candidates);
    }

}

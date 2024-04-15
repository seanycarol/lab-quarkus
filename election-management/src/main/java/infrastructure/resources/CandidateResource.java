package infrastructure.resources;

import api.CandidateApi;
import api.dto.in.CreateCandidate;
import api.dto.in.UpdateCandidate;
import api.dto.out.CandidateResponse;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/candidates")
public class CandidateResource {
    private final CandidateApi candidateApi;

    public CandidateResource(CandidateApi candidateApi) {
        this.candidateApi = candidateApi;
    }

    @POST
    @ResponseStatus(RestResponse.StatusCode.CREATED)
    @Transactional
    public void create(CreateCandidate dto) {
        candidateApi.create(dto);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public CandidateResponse update(@PathParam("id") String id, UpdateCandidate dto) {
        return candidateApi.update(id, dto);
    }

    @GET
    public List<CandidateResponse> list() {
        return candidateApi.list();
    }
}

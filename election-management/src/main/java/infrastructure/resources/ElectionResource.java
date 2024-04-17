package infrastructure.resources;

import api.ElectionApi;
import api.dto.out.ElectionResponse;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/elections")
public class ElectionResource {
    private final ElectionApi electionApi;

    public ElectionResource(ElectionApi electionApi) {
        this.electionApi = electionApi;
    }

    @POST
    @ResponseStatus(RestResponse.StatusCode.CREATED)
    @Transactional
    public void submit() {
        electionApi.submit();
    }

    @GET
    public List<ElectionResponse> list(){
        return electionApi.findAll();
    }
}

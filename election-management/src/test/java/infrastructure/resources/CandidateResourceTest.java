package infrastructure.resources;

import api.CandidateApi;
import api.dto.in.CreateCandidate;
import api.dto.in.UpdateCandidate;
import api.dto.out.CandidateResponse;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.instancio.Instancio;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@QuarkusTest
@TestHTTPEndpoint(CandidateResource.class)
class CandidateResourceTest {
    @InjectMock
    CandidateApi candidateApi;

    @Test
    void create() {
        var in = Instancio.create(CreateCandidate.class);

        given().contentType(MediaType.APPLICATION_JSON).body(in)
                        .when().post()
                        .then().statusCode(RestResponse.StatusCode.CREATED);

        verify(candidateApi).create(in);
        verifyNoMoreInteractions(candidateApi);
    }

    @Test
    void update() {
        var id = UUID.randomUUID().toString();
        var in = Instancio.create(UpdateCandidate.class);
        var out = Instancio.create(CandidateResponse.class);

        when(candidateApi.update(id, in)).thenReturn(out);

        var response = given().contentType(MediaType.APPLICATION_JSON).body(in)
                .when().put("/" + id)
                .then().statusCode(RestResponse.StatusCode.OK)
                .extract().as(CandidateResponse.class);

        verify(candidateApi).update(id, in);
        verifyNoMoreInteractions(candidateApi);

        assertEquals(out, response);
    }

    @Test
    void list() {
        var out = Instancio.stream(CandidateResponse.class).limit(10).toList();

        when(candidateApi.list()).thenReturn(out);

        var response = given()
                .when().get()
                .then().statusCode(RestResponse.StatusCode.OK)
                .extract().as(CandidateResponse[].class);

        verify(candidateApi).list();
        verifyNoMoreInteractions(candidateApi);

        assertEquals(out, Arrays.stream(response).toList());
    }
}
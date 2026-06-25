package es.uah.serverFilmAffinity2.steps;

import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import es.uah.serverFilmAffinity2.model.Actor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
public class ActorSteps {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ActorRepo actorRepo;

    private MvcResult result;

    @Given("I have an actor with existing ID {int}")
    public void actor_exists(Integer id) {
        Actor actor = new Actor();
        actor.setId(id);
        actor.setNombre("Leonardo DiCaprio");

        actorRepo.save(actor);
    }

    @When("I request GET {string}")
    public void request_get(String endpoint) throws Exception {
        result = mockMvc.perform(get(endpoint))
                .andReturn();
    }

    @Then("response status should be {int}")
    public void response_status_should_be(Integer status) {
        assertEquals(status.intValue(),
                result.getResponse().getStatus());
    }

    @And("response should contain name {string}")
    public void response_should_contain_name(String name) throws Exception {
        String body = result.getResponse().getContentAsString();
        assertTrue(body.contains(name));
    }
}

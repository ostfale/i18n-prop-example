package de.ostfale.qk;

import de.ostfale.qk.i18n.AppMessages;
import de.ostfale.qk.i18n.DatabaseMessageSource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;

@Path("/greet")
@Produces(MediaType.TEXT_PLAIN)
public class GreetingResource {

    @Inject
    AppMessages messages;

    @Inject
    DatabaseMessageSource dbMessages;

    @GET
    public String sayHello() {
        return messages.welcome();
    }

    @GET
    @Path("/bye/{name}")
    public String sayGoodbye(@PathParam("name") String name) {
        return messages.goodbye(name);
    }

    @GET
    @Path("/db-greet")
    public String greetFromDb() {
        return dbMessages.getMessage("db.welcome");
    }
}

package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Case;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/case")
public class CaseResource {

    @POST
    @Path("case/{type}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Case caso, @PathParam("type") int tipo) {

        String[] tipos = {"perdida", "robo", "fallecimiento"};

        return Response.status(Response.Status.CREATED)
                .entity(caso)
                .build();

    }
}

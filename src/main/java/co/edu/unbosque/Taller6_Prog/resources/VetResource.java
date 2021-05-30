package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user/{user_id}/vet")
public class VetResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Vet vet,
                           @PathParam("user_id") String user_id) {
        vet.setUsername(user_id);
        return Response.status(Response.Status.CREATED)
                .entity(vet)
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("user_id") String user_id, Vet vet) {
        vet.setUsername(user_id);
        return Response.ok()
                .entity(vet)
                .build();

    }
}

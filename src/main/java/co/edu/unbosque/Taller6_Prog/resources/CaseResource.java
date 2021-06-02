package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Case;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;

@Path("pet/{pet_id}/case/{type}")
public class CaseResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Case caso,
                           @PathParam("type") int tipo,
                           @PathParam("pet_id") int pet_id) {
        String[] tipos = {"perdida", "robo", "fallecimiento"};
        Random rnd = new Random();

        caso.setPet_id(pet_id);
        caso.setType(tipos[tipo]);
        caso.setId(rnd.nextInt(10000));


        return Response.status(Response.Status.CREATED)
                .entity(caso)
                .build();

    }
}

package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Visit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;

@Path("vet/{vet_id}/pet/{pet_id}/visit/{type}/{microchip}")
public class VisitResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("vet_id") String vet_id,
                           @PathParam("pet_id") int pet_id,
                           @PathParam("type") int type,
                           @PathParam("microchip") int microchip,
                           Visit visit) {
        String[] tipos = {"esterilizacion", "implantación de microchip",
                "vacunación", "desparasitación", "urgencia", "control"};

        Random rnd = new Random();
        int visit_id = rnd.nextInt(10000);

        visit.setVet_id(vet_id);
        visit.setPet_id(pet_id);
        visit.setType(tipos[type]);
        visit.setVisit_id(visit_id);

        if (type == 1) {
            visit.setMicrochip(microchip);
        }


        return Response.status(Response.Status.CREATED)
                .entity(visit)
                .build();

    }
}

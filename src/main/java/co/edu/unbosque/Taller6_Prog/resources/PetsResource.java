package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Owner;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owners/{owner_id}/pets")
public class PetsResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("owner_id") Integer ownerId,@QueryParam("querryParam")@DefaultValue("123")long microship, Pet pet) {
        pet.setPet_id(3);
        pet.setMicrochip(microship);
        pet.setOwner_id(ownerId);
        pet.setName("Perro");
        pet.setSex("Macho");
        pet.setSize("Pequenio");
        pet.setSpecies("maltes");
        return Response.status(Response.Status.CREATED)
                .entity(pet)
                .build();
    }

}

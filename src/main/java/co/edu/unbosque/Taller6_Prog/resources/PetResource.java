package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Owner;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owners/{owner_id}/pets/{pet_id}")
public class PetResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("owner_id") Integer ownerId, @PathParam("pet_id") Integer petId, Pet pet) {
        pet.setOwner_id(ownerId);
        pet.setPet_id(petId);
        pet.setSpecies("Species modified");
        pet.setSize("size modified");
        pet.setName("name modified");
        pet.setRace("Race modified");
        pet.setMicrochip(1);
        return Response.ok()
                .entity(pet)
                .build();

    }




}

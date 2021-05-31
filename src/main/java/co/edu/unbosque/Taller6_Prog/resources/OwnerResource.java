package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Owner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owners/{username}")
public class OwnerResource {
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, Owner owner) {
        owner.setPerson_id(3);
        owner.setName("Name modified");
        owner.setNeighborhood("Neighborhood modified");
        owner.setAddress("Adrress modified");
        owner.setUsername(username);
        return Response.ok()
                .entity(owner)
                .build();
    }




}

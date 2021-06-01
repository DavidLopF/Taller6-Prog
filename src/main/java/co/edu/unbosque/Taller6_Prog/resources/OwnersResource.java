package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Notification;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Owner;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/owners")
public class OwnersResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Owner owner) {
        owner.setPerson_id(3);
        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response filter(@QueryParam("filter") String filtro, @QueryParam("value") String value) {
        ArrayList<Owner> owners = new ArrayList<>();
        ArrayList<Owner> result = new ArrayList<>();

        owners.add(new Owner("Usuario1", 1, "Chad", "address1", "Bosa"));
        owners.add(new Owner("Usuario2", 2, "Chad", "address2", "Usaquen"));
        owners.add(new Owner("Usuario3", 3, "Piter", "address3", "Usaquen"));
        owners.add(new Owner("Usuario4", 1, "Jackson", "address4", "Usaquen"));

        owners.get(0).addPet(new Pet(1,2,"Pet1","specie1","race1","size1","macho",owners.get(0).getPerson_id()));
        owners.get(0).addPet(new Pet(2,2,"Pet2","specie2","race2","size2","hembra",owners.get(0).getPerson_id()));
        owners.get(0).addPet(new Pet(3,2,"Pet3","specie3","race3","size3","macho",owners.get(0).getPerson_id()));

        owners.get(3).addPet(new Pet(4,2,"Pet4","specie4","race4","size4","hembra",owners.get(3).getPerson_id()));
        owners.get(3).addPet(new Pet(5,2,"Pet5","specie5","race5","size5","macho",owners.get(3).getPerson_id()));



        for (Owner o : owners) {
            if (filtro.equalsIgnoreCase("identificacion")) {
                if (o.getPerson_id() == Integer.parseInt(value)) {
                    result.add(o);
                }
            } else if (filtro.equalsIgnoreCase("nombre")) {
                if (o.getName().equals(value)) {
                    result.add(o);
                }
            } else if (filtro.equalsIgnoreCase("localidad")) {
                if (o.getNeighborhood().equals(value)) {
                    result.add(o);
                }
            }

        }
        return Response.status(Response.Status.CREATED)
                .entity(result)
                .build();
    }


}

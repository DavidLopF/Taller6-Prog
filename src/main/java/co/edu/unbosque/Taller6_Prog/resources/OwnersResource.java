package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Notification;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Owner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

import java.util.List;


@Path("/owners/{filter}/filters/{value}")
public class OwnersResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner("brix",1, "briannysm", "calle 147", "usaquen"));
        owners.add(new Owner("brisita",2, "brimonse", "calle 147", "cedritos"));

        return Response.status(Response.Status.CREATED)
                .entity(owners)
                .build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response filter(@PathParam("filter") String filtro, @PathParam("value") String value) {
        ArrayList<Owner> owners = new ArrayList<>();
        ArrayList<Owner> result = new ArrayList<>();

        owners.add(new Owner("Usuario1", 1, "Chad", "address1", "Bosa"));
        owners.add(new Owner("Usuario2", 2, "Chad", "address2", "Usaquen"));
        owners.add(new Owner("Usuario3", 3, "Piter", "address3", "Usaquen"));
        owners.add(new Owner("Usuario4", 1, "Jackson", "address4", "Usaquen"));

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

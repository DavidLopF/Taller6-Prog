package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.Notification;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Owner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/owners")
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
}

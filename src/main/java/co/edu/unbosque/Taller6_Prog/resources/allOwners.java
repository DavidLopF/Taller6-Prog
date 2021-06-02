package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/allOwners")
public class allOwners {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response create() {
        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner("Usuario1", 1, "Chad", "address1", "Bosa"));
        owners.add(new Owner("Usuario5", 5, "Bri", "address5", "Bosa"));
        owners.add(new Owner("Usuario2", 2, "Chad", "address2", "Usaquen"));
        owners.add(new Owner("Usuario3", 3, "Piter", "address3", "Usaquen"));
        owners.add(new Owner("Usuario6", 6, "Devid <3", "address6", "Usaquen"));
        owners.add(new Owner("Usuario4", 4, "Jackson", "address4", "Usaquen"));

        List<DiscriminateOwnersPets> discriminateOwnersPets = new ArrayList<DiscriminateOwnersPets>();
        ListOwners listOwners = new ListOwners(owners.size(), discriminateOwnersPets);
        locations(owners, listOwners, "Bosa", listOwners.getDiscriminateOwnersPets());
        locations(owners, listOwners, "Usaquen", listOwners.getDiscriminateOwnersPets());

            return Response.status(Response.Status.CREATED)
                    .entity(listOwners)
                    .build();
    }

    private void locations (List<Owner> owners, ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        for (Owner owner : owners) {
            if (owner.getNeighborhood().equals(name)) {
                count = allPets.getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }
    }
}

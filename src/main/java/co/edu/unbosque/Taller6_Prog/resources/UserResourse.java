package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserResourse {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User user) {

        return Response.status(Response.Status.CREATED)
                .entity(user)
                .build();
    }

}

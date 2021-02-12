package org.episen.fise.getting.started;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jboss.resteasy.annotations.Body;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/owner/{identification}")
public class OwnerResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateOwner(@PathParam("identification") String identification, Owner owner ) {
        OwnerGrpcService.identificationNameMap.replace(identification,owner.getName());

        return "Sucessfully replaced";
    }

}

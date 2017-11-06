package com.mccorby.federatedlearning.server.web;

import com.mccorby.federatedlearning.server.FederatedServerImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/service/federatedservice")
public class RestService {

    @GET
    @Path("/available")
    @Produces(MediaType.TEXT_PLAIN)
    public String available() {
        return "yes";
    }

    @GET
    @Path(("/register"))
    public Integer register() {
        return FederatedServerImpl.getInstance().registerNewModel();
    }

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/gradient")
    public Boolean pushGradient(final byte[] is) {
        if (is == null) {
            return false;
        } else {
            FederatedServerImpl.getInstance().pushGradient(is);
            return true;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/gradient")
    public byte[] getGradient() {
        return FederatedServerImpl.getInstance().sendUpdatedGradient();
    }
}

package org.episen.fise.getting.started.Resource;

import io.quarkus.grpc.runtime.annotations.GrpcService;
import org.episen.fise.getting.started.model.Bike;
import org.episen.fise.proto.OwnerGrpc;
import org.episen.fise.proto.OwnerIdentification;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/bikes")
public class BikeResource {

    @Inject
    @GrpcService("owner")
    OwnerGrpc.OwnerBlockingStub ownerBlockingStub;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Bike> getAllNotes(){
        ArrayList<Bike> bikeArrayList = new ArrayList<>();

        //BIKE 1
        bikeArrayList.add(new Bike("VTT maître des montagnes 200","500","AB-123-CD",ownerBlockingStub.getOwner(
                OwnerIdentification.newBuilder()
                        .setIdentification("AB-123-CD")
                        .build()
        ).getName()));

        //BIKE 2
        bikeArrayList.add(new Bike("NIMBUS 2000","1000","54-123-FP",ownerBlockingStub.getOwner(
                OwnerIdentification.newBuilder()
                        .setIdentification("54-123-FP")
                        .build()
        ).getName()));

        //BIKE 3
        bikeArrayList.add(new Bike("K2000","15000","AP-447-CR",ownerBlockingStub.getOwner(
                OwnerIdentification.newBuilder()
                        .setIdentification("AP-447-CR")
                        .build()
        ).getName()));


        return bikeArrayList;


    }


}

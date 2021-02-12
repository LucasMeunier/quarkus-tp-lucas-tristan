package org.episen.fise.getting.started.Resource;

import org.episen.fise.getting.started.model.Bike;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

@Path("/bikes")
public class BikeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Bike> getAllNotes(){
        ArrayList<Bike> bikeArrayList = new ArrayList<>();
        bikeArrayList.add(new Bike("VTT maître des montagnes 200","500","AB-123-CD"));
        bikeArrayList.add(new Bike("NIMBUS 2000","1000","54-123-FP"));
        bikeArrayList.add(new Bike("K2000","15000","AP-447-CR"));

        return bikeArrayList;


    }


}

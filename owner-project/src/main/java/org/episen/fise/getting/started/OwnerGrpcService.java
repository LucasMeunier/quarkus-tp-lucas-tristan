package org.episen.fise.getting.started;

import io.grpc.stub.StreamObserver;
import org.episen.fise.proto.OwnerGrpc;
import org.episen.fise.proto.OwnerIdentification;
import org.episen.fise.proto.OwnerNameReply;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;


@Singleton
public class OwnerGrpcService extends OwnerGrpc.OwnerImplBase {

    public static Map<String, String> identificationNameMap;
    static {
        identificationNameMap = new HashMap<>();
        identificationNameMap.put("AB-123-CD", "Emam");
        identificationNameMap.put("54-123-FP", "Meunier");
        identificationNameMap.put("AP-447-CR", "Da Silva Sousa");
    }

    @Override
    public void getOwner(OwnerIdentification request, StreamObserver<OwnerNameReply> responseObserver) {
        String identification = request.getIdentification();
        String nom = "";

        nom = identificationNameMap.get(identification);
        if(nom==null){nom = "inconnu";}

        responseObserver.onNext(OwnerNameReply
                .newBuilder()
                .setName(nom)
                .build()
        );
        responseObserver.onCompleted();
    }

}

package org.episen.fise.getting.started;

import io.grpc.stub.StreamObserver;
import org.episen.fise.proto.OwnerGrpc;
import org.episen.fise.proto.OwnerIdentification;
import org.episen.fise.proto.OwnerNameReply;

import javax.inject.Singleton;

@Singleton
public class OwnerGrpcService extends OwnerGrpc.OwnerImplBase {

    @Override
    public void getOwner(OwnerIdentification request, StreamObserver<OwnerNameReply> responseObserver) {
        String identification = request.getIdentification();
        String nom = "";

        switch (identification){
            case "AB-123-CD":
                nom = "Emam";
                break;
            case "54-123-FP":
                nom = "Meunier";
                break;
            case "AP-447-CR":
                nom = "Da Silva Sousa";
                break;
            default:
                nom = "inconnu";
                break;
        }

        responseObserver.onNext(OwnerNameReply
                .newBuilder()
                .setName(nom)
                .build()
        );
        responseObserver.onCompleted();
    }

}

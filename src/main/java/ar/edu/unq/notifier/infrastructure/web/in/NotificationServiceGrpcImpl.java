package ar.edu.unq.notifier.infrastructure.web.in;

import ar.edu.unq.notifier.NotificationServiceGrpc;
import ar.edu.unq.notifier.SaleNotificationGrpcRequest;
import ar.edu.unq.notifier.SaleNotificationGrpcResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class NotificationServiceGrpcImpl extends NotificationServiceGrpc.NotificationServiceImplBase {

    @Override
    public void notifySale(SaleNotificationGrpcRequest request, StreamObserver<SaleNotificationGrpcResponse> responseObserver) {

        generateSellerNotification(request);
        generateUserNotification(request);

        SaleNotificationGrpcResponse response = SaleNotificationGrpcResponse.newBuilder().setNotificationStatus("200 SENT").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void generateSellerNotification(SaleNotificationGrpcRequest request) {
        String sellerNotification = "Seller with id: {} has sold: {} units. Of the product with id: {}. For a total sale value: {}.";
        log.info("SELLER NOTIFICATION:");
        log.info(sellerNotification, request.getSellerId(), request.getProductAmount(), request.getProductId(), request.getSaleValue());
    }

    private void generateUserNotification(SaleNotificationGrpcRequest request) {
        String UserNotification = "User with id: {} has bought: {} units. Of the product with id: {}. For a total sale value: {}.";
        log.info("BUYER NOTIFICATION:");
        log.info(UserNotification, request.getBuyerId(), request.getProductAmount(), request.getProductId(), request.getSaleValue());
    }
}

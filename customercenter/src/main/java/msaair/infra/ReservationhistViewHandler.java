package msaair.infra;

import msaair.domain.*;
import msaair.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationhistViewHandler {

    @Autowired
    private ReservationhistRepository reservationhistRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCreated_then_CREATE_1 (@Payload ReservationCreated reservationCreated) {
        try {

            if (!reservationCreated.validate()) return;

            // view 객체 생성
            Reservationhist reservationhist = new Reservationhist();
            // view 객체에 이벤트의 Value 를 set 함
            reservationhist.setReservationId(reservationCreated.getReservationId());
            reservationhist.setReservationStatus("주문생성");
            // view 레파지 토리에 save
            reservationhistRepository.save(reservationhist);

        }catch (Exception e){
            e.printStackTrace();
        }
    }




}


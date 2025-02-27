package malltail.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import malltail.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import malltail.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ShippingCompleted'")
    public void wheneverShippingCompleted_AddToCustomsList(@Payload ShippingCompleted shippingCompleted){

        ShippingCompleted event = shippingCompleted;
        System.out.println("\n\n##### listener AddToCustomsList : " + shippingCompleted + "\n\n");


        

        // Sample Logic //
        Delivery.addToCustomsList(event);
        

        

    }

}



package malltail.domain;

import malltail.domain.*;
import malltail.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private Long orderNo;
    private Long itemNo;
    private Long qty;
    private Date createDate;
    private String status;
    private String orderStatus;
    private String deliveryStatus;
    private String customerId;
    private String customerAddress;
    private String customerName;
    private String phoneNumber;
    private Date updateDate;

    public OrderCanceled(OrderManagement aggregate){
        super(aggregate);
    }
    public OrderCanceled(){
        super();
    }
}

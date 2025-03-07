package malltail.infra;
import malltail.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/orderManagements")
@Transactional
public class OrderManagementController {
    @Autowired
    OrderManagementRepository orderManagementRepository;




    @RequestMapping(value = "orderManagements/{id}/cancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public OrderManagement cancel(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /orderManagement/cancel  called #####");
            Optional<OrderManagement> optionalOrderManagement = orderManagementRepository.findById(id);
            
            optionalOrderManagement.orElseThrow(()-> new Exception("No Entity Found"));
            OrderManagement orderManagement = optionalOrderManagement.get();
            orderManagement.cancel();
            
            orderManagementRepository.save(orderManagement);
            return orderManagement;
            
    }
    



}

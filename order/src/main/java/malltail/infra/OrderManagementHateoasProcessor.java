package malltail.infra;
import malltail.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class OrderManagementHateoasProcessor implements RepresentationModelProcessor<EntityModel<OrderManagement>>  {

    @Override
    public EntityModel<OrderManagement> process(EntityModel<OrderManagement> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/cancel").withRel("cancel"));

        
        return model;
    }
    
}

package com.pgcrp.publicgrievancecomplaintredressalportal.strategy;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;

import java.util.List;

public interface ComplaintRoutingStrategy {

    FieldWorker assignWorker(
            Complaint complaint,
            List<FieldWorker> workers
    );

}

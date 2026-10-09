package com.pgcrp.publicgrievancecomplaintredressalportal.strategy;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;

import java.util.List;

public class LeastLoadedRouting implements ComplaintRoutingStrategy {

    @Override
    public FieldWorker assignWorker(
            Complaint complaint, List<FieldWorker> workers) {

        FieldWorker selected = null;
        int minimum = Integer.MAX_VALUE;

        for (FieldWorker worker : workers) {
            if (worker.isAvailable()
                    && worker.getActiveComplaintCount() < minimum) {

                minimum = worker.getActiveComplaintCount();
                selected = worker;
            }
        }

        return selected;
    }

}

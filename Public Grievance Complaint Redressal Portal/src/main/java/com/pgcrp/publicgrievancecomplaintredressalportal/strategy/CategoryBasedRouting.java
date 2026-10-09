package com.pgcrp.publicgrievancecomplaintredressalportal.strategy;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;

import java.util.List;

public class CategoryBasedRouting implements ComplaintRoutingStrategy {

    @Override
    public FieldWorker assignWorker(
            Complaint complaint, List<FieldWorker> workers) {

        for (FieldWorker worker : workers) {
            if (worker.isAvailable()
                    && worker.getDepartment() != null
                    && worker.getDepartment()
                    .equalsIgnoreCase(complaint.getCategory())) {
                return worker;
            }
        }

        return null;
    }

}
package com.pgcrp.publicgrievancecomplaintredressalportal.strategy;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;

import java.util.List;

public class CategoryBasedRouting implements ComplaintRoutingStrategy {

    @Override
    public FieldWorker assignWorker(
            Complaint complaint, List<FieldWorker> workers) {

        return workers.stream()
                .filter(worker -> worker.isAvailable()
                        && worker.getDepartment() != null
                        && worker.getDepartment()
                        .equalsIgnoreCase(complaint.getCategory()))
                .findFirst()
                .orElse(null);
    }
}
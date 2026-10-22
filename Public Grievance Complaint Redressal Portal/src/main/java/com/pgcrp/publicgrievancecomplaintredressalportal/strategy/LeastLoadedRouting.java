package com.pgcrp.publicgrievancecomplaintredressalportal.strategy;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;

import java.util.List;
import java.util.Comparator;

public class LeastLoadedRouting implements ComplaintRoutingStrategy {

    @Override
    public FieldWorker assignWorker(
            Complaint complaint, List<FieldWorker> workers) {

        return workers.stream()
                .filter(worker -> worker.isAvailable())
                .min(Comparator.comparingInt(
                        worker -> worker.getActiveComplaintCount()))
                .orElse(null);
    }
}
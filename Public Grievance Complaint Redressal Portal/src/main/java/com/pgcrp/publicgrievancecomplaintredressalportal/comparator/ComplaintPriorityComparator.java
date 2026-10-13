package com.pgcrp.publicgrievancecomplaintredressalportal.comparator;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;

import java.util.Comparator;

public class ComplaintPriorityComparator implements Comparator<Complaint> {

    private int priorityRank(String priority) {

        if (priority == null) {
            return 4;
        }

        return switch (priority.toUpperCase()) {
            case "HIGH" -> 1;
            case "MEDIUM" -> 2;
            case "NORMAL" -> 3;
            case "LOW" -> 4;
            default -> 5;
        };
    }

    @Override
    public int compare(Complaint c1, Complaint c2) {

        int result = Integer.compare(
                priorityRank(c1.getPriority()),
                priorityRank(c2.getPriority())
        );

        if (result != 0) {
            return result;
        }

        return c1.getComplaintId().compareTo(c2.getComplaintId());
    }
}
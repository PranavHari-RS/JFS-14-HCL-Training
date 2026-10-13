package com.pgcrp.publicgrievancecomplaintredressalportal.comparator;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;

import java.util.Comparator;

public class ComplaintStatusComparator implements Comparator<Complaint> {

    @Override
    public int compare(Complaint c1, Complaint c2) {

        int result = String.CASE_INSENSITIVE_ORDER.compare(
                c1.getStatus(),
                c2.getStatus()
        );

        if (result != 0) {
            return result;
        }

        return c1.getComplaintId().compareTo(c2.getComplaintId());
    }
}
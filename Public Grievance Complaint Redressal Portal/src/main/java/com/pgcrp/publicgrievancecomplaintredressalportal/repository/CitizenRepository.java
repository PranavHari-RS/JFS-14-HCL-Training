package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Citizen;

public class CitizenRepository
        extends InMemoryRepository<Citizen, String> {

    public CitizenRepository() {
        super(Citizen::getCitizenId);
    }
}
package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;

public class FieldWorkerRepository
        extends InMemoryRepository<FieldWorker, String> {

    public FieldWorkerRepository() {
        super(FieldWorker::getWorkerId);
    }
}
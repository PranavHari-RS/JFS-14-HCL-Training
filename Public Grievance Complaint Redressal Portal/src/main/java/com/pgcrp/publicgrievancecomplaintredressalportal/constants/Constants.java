package com.pgcrp.publicgrievancecomplaintredressalportal.constants;

public final class Constants {

    private Constants() {
        // Prevent object creation
    }

    // Complaint Status
    public static final String STATUS_SUBMITTED = "SUBMITTED";
    public static final String STATUS_UNDER_REVIEW = "UNDER_REVIEW";
    public static final String STATUS_IN_PROGRESS = "IN_PROGRESS";
    public static final String STATUS_RESOLVED = "RESOLVED";
    public static final String STATUS_REJECTED = "REJECTED";

    // Complaint Priority
    public static final String PRIORITY_LOW = "LOW";
    public static final String PRIORITY_MEDIUM = "MEDIUM";
    public static final String PRIORITY_HIGH = "HIGH";
    public static final String PRIORITY_CRITICAL = "CRITICAL";

    // Complaint Categories
    public static final String CATEGORY_WATER = "WATER";
    public static final String CATEGORY_ROADS = "ROADS";
    public static final String CATEGORY_ELECTRICITY = "ELECTRICITY";
    public static final String CATEGORY_SANITATION = "SANITATION";
    public static final String CATEGORY_DRAINAGE = "DRAINAGE";

    // Business Rules
    public static final int MIN_DESCRIPTION_LENGTH = 10;
    public static final int MAX_DESCRIPTION_LENGTH = 1000;

    public static final int HIGH_PRIORITY_SLA_DAYS = 3;
    public static final int MEDIUM_PRIORITY_SLA_DAYS = 7;
    public static final int LOW_PRIORITY_SLA_DAYS = 15;

    // Default Values
    public static final String DEFAULT_STATUS = STATUS_SUBMITTED;
    public static final String DEFAULT_PRIORITY = PRIORITY_MEDIUM;
}

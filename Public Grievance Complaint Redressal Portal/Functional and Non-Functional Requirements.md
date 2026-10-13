A. Functional requirements (FR)

Functional requirements describe what the system should do.
ID	Functional requirement
FR1	Citizen can file a complaint by providing the complaint description and necessary details.
FR2	The system can route complaints to the appropriate department or authority.
FR3	An administrator can assign a field worker to a complaint.
FR4	Authorized users can update complaint statuses.
FR5	The system can escalate complaints that remain unresolved beyond the permitted time.
FR6	Citizens can track complaint status using a complaint ID.
FR7	Citizens can rate the resolution or reopen a complaint when necessary.
FR8	The system can display SLA (Service Level Agreement) compliance information.


B. Non-functional requirements (NFR)

Non-functional requirements describe how well and how securely the system should work.
ID	Non-functional requirement
NFR1 – Performance	Complaint registration and tracking should respond within an acceptable time.
NFR2 – Security	Only authorized users should perform restricted operations.
NFR3 – Reliability	Complaint data should be stored consistently without unintended loss.
NFR4 – Maintainability	The application should use modular classes and a clear separation of responsibilities.
NFR5 – Usability	The menu and messages should be simple and understandable for users.
NFR6 – Data integrity	Complaint IDs, statuses, and related records should be validated before operations.
NFR7 – Scalability	The design should support adding more departments, workers, and complaint-handling features.
NFR8 – Auditability	Important complaint status changes and escalations should be traceable.
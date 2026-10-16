# AI Usage Documentation

## Project
Public Grievance Complaint Redressal Portal

## Day 11 - AI-Assisted Development

### AI Tool Used
GitHub Copilot

### Purpose
To assist in generating an additional entity and
repository for the complaint feedback functionality.

### Generated Components

1. ComplaintFeedback.java
2. ComplaintFeedbackRepository.java

### AI Assistance

GitHub Copilot was used to suggest:

- Entity structure
- Constructors
- Getter and setter methods
- Repository methods
- In-memory storage implementation

### Code Review

The generated code was reviewed for:

- Correct Java syntax
- Compatibility with existing classes
- Proper object-oriented design
- Input validation
- Exception handling
- Repository integration

### Human Contributions

- Reviewed AI-generated code
- Verified business requirements
- Checked integration with existing project
- Corrected errors where necessary
- Tested application functionality

### Functional Requirements

FR7 - Rate and Reopen Complaint

FR8 - View SLA Compliance

### Conclusion

AI was used as a development assistant.
All generated code must be reviewed and tested
before being included in the project.

## Day 11 Implementation and Testing

### Functional Requirements Implemented

FR7 - Rate/Reopen Complaint
- Implemented complaint rating functionality.
- Added feedback submission.
- Implemented complaint reopening.
- Verified complaint status updates.

FR8 - View SLA Compliance
- Implemented SLA deadline calculation.
- Added SLA compliance reporting.
- Displayed compliant and breached complaint counts.
- Handled complaints with unavailable timestamps.

### Testing Results

- FR7 rating functionality verified successfully.
- FR7 complaint reopening verified successfully.
- FR8 SLA report displayed successfully.
- SLA compliance percentage calculated correctly for evaluated complaints.
- Existing CSV complaints without timestamps displayed DATA UNAVAILABLE.

### AI Code Review

- Reviewed ComplaintFeedback entity.
- Reviewed ComplaintFeedbackRepository implementation.
- Checked integration with existing project classes.
- Verified basic FR7 and FR8 functionality.
# Day 11 - AI Code Review Log

## Project
Prompt & Review Drill

## AI Tool
GitHub Copilot

## Reviewed File
StudentService.java

## Issues Identified During Code Review

| No. | Issue Found | Problem | Fix Applied |
|---|---|---|---|
| 1 | Duplicate Student IDs | addStudent() allows duplicate IDs | Added duplicate ID validation |
| 2 | Invalid Student IDs | Lookup, update and delete accept invalid IDs | Added validateId() |
| 3 | Missing Student Handling | getStudentById() returns null for missing students | Added meaningful exception |
| 4 | Incorrect Update ID | updateStudent() allows changing student IDs | Prevented ID changes during updates |
| 5 | Mutable Object Exposure | getAllStudents() exposes mutable Student objects | Added defensive copying |
| 6 | Incomplete Student Validation | Service accepts incomplete Student objects | Added validateStudent() |

## Summary

Total Issues Identified: 6

Total Issues Fixed: 6

## Conclusion

GitHub Copilot generated the initial StudentService.java.

During manual code review, six issues were identified.

The issues were corrected by implementing proper validation,
exception handling, duplicate prevention, and defensive copying.

## Testing and Verification

The corrected StudentService.java was tested
using PromptReviewDrillApplication.java.

| No. | Test Case | Result |
|---|---|---|
| 1 | Duplicate Student ID | PASS |
| 2 | Invalid Student ID | PASS |
| 3 | Student Not Found | PASS |
| 4 | Incorrect Update ID | PASS |
| 5 | Defensive Copy | PASS |
| 6 | Incomplete Student | PASS |

## Final Review Summary

Total Issues Identified: 6
Total Issues Fixed: 6
Verification Tests Passed: 6

Application Execution: SUCCESS
Exit Code: 0

## Conclusion

GitHub Copilot was used to generate the initial
StudentService.java implementation.

Six issues were identified during code review
and corrected.

The corrected implementation was executed
successfully, and all six verification tests passed.

## Maven Build Verification

Command:
.\mvnw.cmd clean package

Result: BUILD SUCCESS

JUnit Tests Executed: 9

Failures: 0
Errors: 0
Skipped: 0

All StudentService tests passed successfully.
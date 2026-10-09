
# Day 4 Debugging Log

## Bug
Withdrawal failed when the amount was equal to the account balance.

## Reproduction
1. Create an account with a balance of 1000.
2. Deposit 500.
3. Withdraw 1500.

## Debugging Setup
- IDE: IntelliJ IDEA
- Breakpoint: Conditional breakpoint inside withdraw()
- Condition: amount == balance
- Watches: amount, balance, amount == balance

## Root Cause
The condition used amount < balance instead of amount <= balance.

## Fix
Changed the comparison operator from < to <=.

## Verification
Withdrawal succeeded and the final balance was 0.0.

## Hot Code Replace
Record whether IntelliJ successfully reloaded the modified class
while debugging, or whether a restart was required.
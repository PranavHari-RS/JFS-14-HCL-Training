InvalidQuantityException:
1.
OrderProcessorApplication calls testOrder(processor, "abc", 10). testOrder calls processOrder, which tries to parse "abc" as an integer at OrderProcessor.java:10. Integer.parseInt("abc") fails and throws the original NumberFormatException.
2.
processOrder catches that exception. At OrderProcessor.java:36, it throws an InvalidQuantityException with the message “Quantity must be a valid whole number.” It passes the caught exception as the cause, preserving the original failure. InvalidQuantityException is the custom exception; it extends RuntimeException.
3.
Before the custom exception propagates out of processOrder, Java executes the finally block, so the audit message is printed even though processing failed. A finally block runs when control leaves the try/catch, including when an exception is being thrown.
4.
The stack frames show where the custom exception propagated: it was thrown in processOrder at line 36, called from testOrder at OrderProcessorApplication.java:35, then from main at line 19.
The original failure was parsing "abc" at line 10; line 36 is where the custom exception was thrown in response. Since the code attaches the NumberFormatException as the cause, a complete printStackTrace() output should also include a Caused by: java.lang.NumberFormatException section. That section is not present in the trace shown, so it may have been omitted or truncated.

InsufficientStockException:
OrderProcessor.processOrder throws InsufficientStockException at OrderProcessor.java:25 because the requested quantity (20) exceeds the available stock (5). The stack frames then show the call path: testOrder at OrderProcessorApplication.java:35, called from main at line 22.
InsufficientStockException is checked because its class extends Exception rather than RuntimeException. Java therefore requires callers to catch it or declare it; processOrder declares it with throws InsufficientStockException.
The testOrder catch block handles it through the multi-catch catch (InvalidQuantityException | InsufficientStockException e): it prints an “Order failed” message and the stack trace. Before the exception propagates out of processOrder, its finally block runs and prints the audit message, whether processing succeeds or fails.
This trace does not demonstrate exception chaining. The exception is thrown directly for insufficient stock, with no underlying exception passed as its cause.
gpt
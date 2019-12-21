# RPN Calc
We're building this command-line calculator for people who are comfortable with UNIX-like CLI utilities. We are starting with the basic 4 operators now but will want to eventually implement other operators and an alternate interface (such as WebSocket, file, or TCP socket).

Example Input/Output
--------------------

    > 5 
    5
    > 8
    8
    > +
    13
 
 Application running instructions:
 ----------------- 
    mvn package
    java -jar target/RPNCalc.jar

In case of additional time it would be nice to implement:
- one line commands input like

      2 2 +

- make better data/commands input source handling
- cover with more tests
- make it more documented
- and support more functions

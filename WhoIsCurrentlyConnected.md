It is useful to know if there is somebody working
on RAPLA before stopping the server.

The connection/disconnection to RAPLA server
are logged in the log file:

> rapla-source-1.0beta1/dist/rapla-webapp-1.0beta1/webapp/WEB-INF/logs/rapla-server.log.000001

This file is difficult to read, the python program attached to this page
takes the log file in its standard input
and outputs a more readable information as:

```
Start date = 21/06 09:59:39, Stop date = Running
 134.214.91.151  ['admin', 'exco']                     ( 4, 3) ### Connected ###
 134.214.88.28   ['cmichel']                           ( 1, 1)
 134.214.88.196  ['dpallez']                           ( 1, 1)
 134.214.88.214  ['eliane']                            ( 1, 0) ### Connected ###
```
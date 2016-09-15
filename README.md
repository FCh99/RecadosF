An employee receives everyday a list of visits to do to customers. The list auto loads upon Starting the phone 
everyday so he has nothing to do but to connect the phone and follow the instructions. A Broadcast Receiver
is in charge of listening to the Booting process and launching an Intent service (which does the work of 
going to the Internet, bringing the json Array, turning it into an ArrayList after sorting it in order)
The phone shows a recyclerView of tasks ordered by time. Pressing an item it shows a detail of it, APP WORKS 
BUT UNFINISHED

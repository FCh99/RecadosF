An employee receives everyday a list of visits to do to customers. The list AUTO LOADS upon starting the phone 
every morning, so he has nothing to do but to connect the phone, wait for the App to AUTOLOAD and follow the instructions. A Broadcast Receiver is in charge of listening to the Booting process and launching an Intent service (which does the work of 
going to the Internet, bringing the json Array and turning it into an ArrayList)
The phone shows a recyclerView of tasks ordered by time. Pressing an item it shows a detail of it

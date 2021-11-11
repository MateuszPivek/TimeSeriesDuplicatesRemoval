# Time Series Duplicates Removal

This short application focus on removing duplications of records recieved from sensors. For simplifying input records are received by scanner from console but
can be replaced with input from file or network socket. App read received records in String split and map them to further procesing.
On output app send only readings that indicate a change of voltage state. 
Code also contains simple method tests that check if the input Strings are correctry processed. Test were made using JUnit version 5.8.1

Application is based on abstract "IOReader" class with methods used to refactor received String data into Integers and mapping them into LinkedHashMap.
Mapped values of keys (timestamps of received records) and values (1 or 0 for different voltage state) are checked and compared to previous packets saved in the map,
if value of reading changes current packet is send to output if the reading has same voltage state as previous app will save it in the map but wont send further.
Abstract class also contains two methods which are implemented in other "IOStreamer" class for simplyfying possible future changes in ways of receiving packets.

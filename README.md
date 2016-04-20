# RES - Labo SMTP

## Objectives

This application is used to send fake emails to people. To do it, we use a predefined list of victims to form groups of victims. 
Then, a sender and at least two recipients are determinated in every group of victims. The sender sends an email to every victims who have been selected in his group.
The sended message is selected randomly from list of messages. When the recipient receives the message, he has to believe that the sender is the origin of it.
To test the use of this application, we used a mock SMTP server. This allow us to test our application and see the echanges and the victims don't really receive the emails. So, there is no
trouble to use the software we developped. The installation of the mock server is described further.


## Configuring

Configuration can be done through the /config folder. It contains three files:

* config.properties
  This file contains the SMTP server configuration (address and port), the number of groups to generate and the witness adress which to send a copy of emails.
  Be carefull to have enough adresses in the victim's list to have at least three addresses per group.
  
* victims.RES
  It contains the victims list. Each address needs one line.
  
* messages.txt
  This file contains the messages to be sent. Each message has a subject and a body and is registred as below:
  
  Subject: Ceci est le sujet

  Ceci est le prank

  //////

## Implementation
![](https://github.com/AdrianoRuberto/Labo-SMTP/blob/master/figures/diagram.png)

We quite used the structure described in the webcast.

* MainRobot  
  This class initializes the application. It imports the configurations and use it to first create a wave of pranks to send using the
  PrankGenerator and then send them with the smtp client he created.

* SmtpClient  
  It represents a SMTP client which is able to send messages. It needs a few parameters such as the port number and the address of the server. 

* ConfigurationManager  
  It is probably one of the most important classes of our project. It is responsible of parsing the configuration files and retrieving the available victims and messages. More, it imports the server configuration. 


## Installing and using a mock Server

As already said, to test or use this application without truly sending emails to recipients, we have to use a mock server.  $

To test our work, we used FakeSMTP, a mock server running on a JVM. So, we could see every sent email and open it with an email software.

To install FakeSMTP, do:

* download FakeSMTP at https://nilhcem.github.io/FakeSMTP/download.html

* Launch it

* Select the SMTP port and start the SMTP server

When the mock server is running, every sent email appears dynamically.






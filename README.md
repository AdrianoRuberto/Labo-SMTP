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


## Installing and using a mock Server

As already said, to test or use this application without truly sending emails to recipients, we have to use a mock server.  $

To test our work, we used FakeSMTP, a mock server running on a JVM.
      
## Evaluation

* You can work in **groups of 2 students**. 

* You are free to **form these groups as you wish**.

* However, we strongly believe that **everybody will benefit if a more experienced student works with a more junior one in a "smart way"** (i.e. does not do all the work, but leads the way). For the experienced student, it is a good opportunity to develop coaching and mentoring skills. For the junior student, it is a good opportunity to learn good practices from a peer.

* Your code and report will be evaluated and you will get a full lab grade. You will also be asked to **do a 5' demo** of your application. Make sure that you prepare a clear and convincing demo scenario in advance.









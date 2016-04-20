package model.prank;

/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : Prank.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : This is a joke to send. So it registers the sender, the recipients,
               the witnesses and the message body. It would be used to generate the messages to send.
 -----------------------------------------------------------------------------------
 */

import model.mail.Message;
import model.mail.Person;

import java.util.LinkedList;
import java.util.List;

public class Prank {

    // recipients
   private final LinkedList<Person> victimR = new LinkedList<>();

    // witnesses
   private final LinkedList<Person> witnessR = new LinkedList<>();

    // sender
   private Person sender;

    // message body
   private String message;

   public LinkedList<Person> getVictimRecipients() {
	  return victimR;
   }

   public LinkedList<Person> getWitnessRecipients() {
	  return witnessR;
   }

   public void addVictimRecipients(List<Person> ps) {
	  victimR.addAll(ps);
   }

   public void addWitnessRecipients(List<Person> ps) {
	  witnessR.addAll(ps);
   }

   public Person getSender() {
	  return sender;
   }

   public void setSender(Person sender) {
	  this.sender = sender;
   }

   public String getMessage() {
	  return message;
   }

   public void setMessage(String message) {
	  this.message = message;
   }

    /*
    ----------------------------------------------------------------------------------
    Description  : Return generated message with all its headers

    ----------------------------------------------------------------------------------
     */
   public Message generateMessage() {
       // Message generation
	  Message msg = new Message();
	  msg.setBody(this.message + "\r\n" + sender.getFirstName());
	  msg.setTo(victimR.stream().map(Person::getAddress).toArray(String[]::new));
	  msg.setCc(witnessR.stream().map(Person::getAddress).toArray(String[]::new));
	  msg.setFrom(sender.getAddress());

	  return msg;
   }
}

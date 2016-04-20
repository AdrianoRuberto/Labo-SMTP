/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : Prank.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Represent a prank
 -----------------------------------------------------------------------------------
 */

package model.prank;

import model.mail.Message;
import model.mail.Person;

import java.util.LinkedList;
import java.util.List;

public class Prank {

   private final List<Person> victimR = new LinkedList<>();
   private final List<Person> witnessR = new LinkedList<>();
   private Person sender;
   private String message;

   public List<Person> getVictimRecipients() {
	  return victimR;
   }

   public List<Person> getWitnessRecipients() {
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

   /**
	* @return a generate message with the involved person
	*/
   public Message generateMessage() {
	  // construction du message a proprement parler
	  Message msg = new Message();
	  msg.setBody(this.message + "\r\n" + sender.getFirstName());
	  msg.setTo(victimR.stream().map(Person::getAddress).toArray(String[]::new));
	  msg.setCc(witnessR.stream().map(Person::getAddress).toArray(String[]::new));
	  msg.setFrom(sender.getAddress());

	  return msg;
   }
}

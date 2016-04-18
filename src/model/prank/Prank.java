package model.prank;
/*
 * Projet : Labo-SMTP
 * Créé le 18.04.2016.
 * Auteur : Adriano Ruberto
 */

import model.mail.Message;
import model.mail.Person;

import java.util.LinkedList;
import java.util.List;

public class Prank {

   private final LinkedList<Person> victimR = new LinkedList<>();
   private final LinkedList<Person> witnessR = new LinkedList<>();
   private Person sender;
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

   public Message generateMessage() {
	  Message msg = new Message();
	  msg.setBody(this.message + "\r\n" + sender.getFirstName());
	  msg.setTo(victimR.stream().map(Person::getAddress).toArray(String[]::new));
	  msg.setCc(witnessR.stream().map(Person::getAddress).toArray(String[]::new));
	  msg.setFrom(sender.getAddress());

	  return msg;
   }
}

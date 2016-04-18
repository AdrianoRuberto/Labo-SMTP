package model.prank;
/*
 * Projet : Labo-SMTP
 * Créé le 16.04.2016.
 * Auteur : Adriano Ruberto
 */

import model.mail.Message;
import model.mail.Person;

import java.util.LinkedList;

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

   public void addVictimRecipients(LinkedList<Person> ps) {
	  victimR.addAll(ps);
   }

   public void addWitnessRecipients(LinkedList<Person> ps) {
	  witnessR.addAll(ps);
   }

   public Person getVictimSender() {
	  return sender;
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

   }
}

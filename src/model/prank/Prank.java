package model.prank;

/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : Prank.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Représente une campagne avec une liste de destinataires, un expéditeur et un message
 -----------------------------------------------------------------------------------
 */

import model.mail.Message;
import model.mail.Person;

import java.util.LinkedList;
import java.util.List;

public class Prank {

    // destinataires
   private final LinkedList<Person> victimR = new LinkedList<>();

    // témoins
   private final LinkedList<Person> witnessR = new LinkedList<>();

    // expéditeur
   private Person sender;

    // contenu du message
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
    Description  : Retourne le message construit avec tous ses en-têtes

    ----------------------------------------------------------------------------------
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

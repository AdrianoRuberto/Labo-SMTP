package model.mail;
/*
 * Projet : Labo-SMTP
 * Créé le 16.04.2016.
 * Auteur : Adriano Ruberto
 */

import java.util.LinkedList;

public class Group {
   private LinkedList<Person> members = new LinkedList<>();

   public void addMember(Person p) {
	  members.add(p);
   }

   public LinkedList<Person> getMembers() {
	  return members;
   }
}

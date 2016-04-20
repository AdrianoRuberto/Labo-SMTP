package model.mail;

/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : Group.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : As its name indicates, it is a group of victims, from which the PrankGenerator gets its victims.
 -----------------------------------------------------------------------------------
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

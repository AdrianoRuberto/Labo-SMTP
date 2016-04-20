/**
 * -----------------------------------------------------------------------------------
 * Laboratoire : Labo-SMTP
 * Fichier     : Group.java
 * Auteur(s)   : Adriano Ruberto && Matthieu Villard
 * Date        : 20.04.2016
 * Description : Represent a group
 * -----------------------------------------------------------------------------------
 */
package model.mail;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Group {
   private List<Person> members = new LinkedList<>();

   /**
	* Add a member to the group
	* @param p
	*/
   public void addMember(Person... p) {
	  Collections.addAll(members, p);
   }

   public List<Person> getMembers() {
	  return members;
   }
}

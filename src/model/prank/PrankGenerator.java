/**
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : PrankGenerator.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Generate the right amount of group with the sender, recipients and
 			   witnesses
 -----------------------------------------------------------------------------------
 */

package model.prank;

import config.ConfigurationManager;
import model.mail.Group;
import model.mail.Person;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PrankGenerator {
   private ConfigurationManager cm;

   public PrankGenerator(ConfigurationManager cm) {
	  this.cm = cm;
   }

   /**
	* Give a generated list of pranks
	* @return the list
	*/
   public List<Prank> pranks() {
	  List<Prank> pranks = new LinkedList<>();
	  List<String> messages = cm.getMessages();

	  final int numberOfGroups = cm.getNumberOfGroups();
	  final int numberOfVictims = cm.getVictims().size();

	  if (numberOfVictims / numberOfGroups < 3) throw new RuntimeException("Not enough victims per groups");

	  List<Group> groups = groups(cm.getVictims(), numberOfGroups);
	  int messageIndex = 0;
	  // Create the groups
	  for (Group group : groups) {
		 Prank prank = new Prank();
		 List<Person> victims = group.getMembers();
		 Collections.shuffle(victims); // Shuffle to randomize
		 Person sender = victims.remove(0);
		 prank.setSender(sender);
		 prank.addVictimRecipients(victims);
		 prank.addWitnessRecipients(cm.getWitnesses());

		 String message = messages.get(messageIndex);
		 messageIndex = (messageIndex + 1) % messages.size(); // Rotation of messages
		 prank.setMessage(message);

		 pranks.add(prank);
	  }

	  return pranks;
   }

   /*
   ----------------------------------------------------------------------------------
   Description  : Construction des groupes

   ----------------------------------------------------------------------------------
	*/

   /**
	* Generate the groups
	* @param victims the people involved for the prank
	* @param numberOfGroups the number of group
	* @return The groups
	*/
   public List<Group> groups(List<Person> victims, int numberOfGroups) {
	  List<Person> availableVictims = new LinkedList<>(victims);
	  Collections.shuffle(availableVictims); // Shuffle to randomize
	  List<Group> groups = new LinkedList<>();
	  // Creation of the groups
	  for (int i = 0; i < numberOfGroups; ++i) {
		 groups.add(new Group());
	  }

	  // Fill the groups
	  Group targetGroup;
	  int turn = 0;
	  while (availableVictims.size() > 0) {
		 targetGroup = groups.get(turn);
		 turn = (turn + 1) % groups.size();
		 Person victim = availableVictims.remove(0);
		 targetGroup.addMember(victim);
	  }

	  return groups;
   }
}

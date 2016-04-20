package model.prank;

/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : PrankGenerator.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : It is used to generate groups and pranks. Depending of the configuration,
 			   it devides victims into random groups and then generate a prank for every group,
 			   determinating randomly sender and victims.
 -----------------------------------------------------------------------------------
 */

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

	/*
    ----------------------------------------------------------------------------------
    Description  : Get pranks with sender, recipients, witnesses and message

    ----------------------------------------------------------------------------------
     */
   public List<Prank> pranks() {
	  List<Prank> pranks = new LinkedList<>();
	  List<String> messages = cm.getMessages();

	  final int numberOfGroups = cm.getNumberOfGroups();
	  final int numberOfVictims = cm.getVictims().size();

	  if (numberOfVictims / numberOfGroups < 3) throw new RuntimeException("Not enough victims per groups");

	  List<Group> groups = groups(cm.getVictims(), numberOfGroups);
	  int messageIndex = 0;
	  for (Group group : groups) {
		 Prank prank = new Prank();
		 List<Person> victims = group.getMembers();
		 Collections.shuffle(victims); // Mix the victims
		 Person sender = victims.remove(0); // get first victim of the random list
		 prank.setSender(sender); // set first victim as sender
		 prank.addVictimRecipients(victims); // set the others as recipients

		 prank.addWitnessRecipients(cm.getWitnesses()); // set witnesses

		  // set message body
		 String message = messages.get(messageIndex);
		 messageIndex = (messageIndex + 1) % messages.size();
		 prank.setMessage(message);

		 pranks.add(prank);

	  }

	  return pranks;
   }

	/*
    ----------------------------------------------------------------------------------
    Description  : Groups generation

    ----------------------------------------------------------------------------------
     */
   public List<Group> groups(List<Person> victims, int numberOfGroups) {
	  List<Person> availableVictims = new LinkedList<>(victims);
	  Collections.shuffle(availableVictims); // Mix the victims
	  List<Group> groups = new LinkedList<>();
	  for (int i = 0; i < numberOfGroups; ++i) {
		 groups.add(new Group());
	  }
	  Group targetGroup;
	  int turn = 0;
	   // Set random groups of victims
	  while (availableVictims.size() > 0) {
		 targetGroup = groups.get(turn);
		 turn = (turn + 1) % groups.size();
		 Person victim = availableVictims.remove(0);
		  // add the victim to the group
		 targetGroup.addMember(victim);
	  }

	  return groups;
   }
}

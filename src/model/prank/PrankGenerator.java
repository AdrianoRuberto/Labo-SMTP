package model.prank;
/*
 * Projet : Labo-SMTP
 * Créé le 16.04.2016.
 * Auteur : Adriano Ruberto
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
		 Collections.shuffle(victims);
		 Person sender = victims.remove(0);
		 prank.setSender(sender);
		 prank.addVictimRecipients(victims);

		 prank.addWitnessRecipients(cm.getWitnesses());

		 String message = messages.get(messageIndex);
		 messageIndex = (messageIndex + 1) % messages.size();
		 prank.setMessage(message);

		 pranks.add(prank);

	  }

	  return pranks;
   }

   public List<Group> groups(List<Person> victims, int numberOfGroups) {
	  List<Person> availableVictims = new LinkedList<>(victims);
	  Collections.shuffle(availableVictims);
	  List<Group> groups = new LinkedList<>();
	  for (int i = 0; i < numberOfGroups; ++i) {
		 groups.add(new Group());
	  }
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

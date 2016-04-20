package model.prank;

/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : PrankGenerator.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Génère les groupes avec les expéditeur, les destinataires et les témoins
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
    Description  : Récupération des campagnes avec expéditeur, destinataires, temoins et message

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
		 Collections.shuffle(victims); // mélange
		 Person sender = victims.remove(0); // première victime du groupe
		 prank.setSender(sender); // expéditeur
		 prank.addVictimRecipients(victims); // destinataires

		 prank.addWitnessRecipients(cm.getWitnesses()); // témoins

		 String message = messages.get(messageIndex); // contenu du message
		 messageIndex = (messageIndex + 1) % messages.size();
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
   public List<Group> groups(List<Person> victims, int numberOfGroups) {
	  List<Person> availableVictims = new LinkedList<>(victims);
	  Collections.shuffle(availableVictims); // mélange
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
		  // affectation de la victime au groupe
		 targetGroup.addMember(victim);
	  }

	  return groups;
   }
}

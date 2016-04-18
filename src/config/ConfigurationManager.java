package config;

import model.mail.Message;
import model.mail.Person;

import java.io.IOException;
import java.util.LinkedList;

public class ConfigurationManager implements IConfigurationManager {

   private final LinkedList<Person> victims;
   private final LinkedList<String> messages;
   private String smtpServerAddress;
   private int smtpServerPort;

   public ConfigurationManager() throws IOException {
	  victims = loadAddressesFromFile("./config/victims.RES");
	  messages = loadMessagesFromFile("./config/messages.txt");
   }

   private LinkedList<String> loadMessagesFromFile(String s) {
	  return null;
   }

   private LinkedList<Person> loadAddressesFromFile(String s) {
	  LinkedList<Person> results;
	  //try(FileStream)
	  return null;

   }

   @Override
   public LinkedList<Person> getVictims() {
	  return null;
   }

   @Override
   public LinkedList<Message> getMessages() {
	  return null;
   }
}

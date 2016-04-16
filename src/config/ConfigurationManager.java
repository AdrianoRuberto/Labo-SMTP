package config;

import model.mail.Message;
import model.mail.Person;

import java.util.List;

public class ConfigurationManager implements IConfigurationManager {

   private String smtpServerAddress;
   private int smtpServerPort;

   @Override
   public List<Person> getVictims() {
	  return null;
   }

   @Override
   public List<Message> getMessages() {
	  return null;
   }
}

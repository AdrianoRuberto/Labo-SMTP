/**
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : ConfigurationManager.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Allow the read a config file and get predefined settings
 -----------------------------------------------------------------------------------
 */

package config;

import model.mail.Person;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ConfigurationManager {
   private final List<Person> victims;
   private final List<String> messages;
   private String smtpServerAddress;
   private int smtpServerPort;
   private int numberOfGroups;
   private List<Person> witnesses;

   public ConfigurationManager() throws IOException {
	  victims = loadAddressesFromFile("./config/victims.RES");
	  messages = loadMessagesFromFile("./config/messages.txt");
	  loadProperties("./config/config.properties");
   }

   /**
	* Load the settings from a file
	* @param path the file path
	* @throws IOException
	*/
   private void loadProperties(String path) throws IOException {
	  FileInputStream file = new FileInputStream(path);
	  Properties prop = new Properties();
	  prop.load(file);
	  this.smtpServerAddress = prop.getProperty("smtpServerAddress");
	  this.smtpServerPort = Integer.parseInt(prop.getProperty("smtpServerPort"));
	  this.numberOfGroups = Integer.parseInt(prop.getProperty("numberOfGroups"));
	  this.witnesses = Arrays.stream(prop.getProperty("witnessToCC").split(","))
							 .map(Person::new)
							 .collect(Collectors.toList());
   }

   /**
	* Give a list of message from a file
	* @param filename the filename
	* @return A list of message
	* @throws IOException
	*/
   private List<String> loadMessagesFromFile(String filename) throws IOException {
	  try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
		 return Arrays.asList(reader.lines().reduce((a, b) -> a + "\r\n" + b).get().split("//////"));
	  }
   }

   /**
	* Give email addresses from a file
	* @param filename the filename
	* @return the list
	* @throws IOException
	*/
   private List<Person> loadAddressesFromFile(String filename) throws IOException {
	  try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
		 return reader.lines().map(Person::new).collect(Collectors.toList());
	  }
   }

   public List<Person> getVictims() {
	  return victims;
   }

   public List<String> getMessages() {
	  return messages;
   }

   public String getSmtpServerAddress() {
	  return smtpServerAddress;
   }

   public int getSmtpServerPort() {
	  return smtpServerPort;
   }

   public int getNumberOfGroups() {
	  return numberOfGroups;
   }

   public List<Person> getWitnesses() {
	  return witnesses;
   }

   public void setWitnesses(List<Person> witnesses) {
	  this.witnesses = witnesses;
   }
}

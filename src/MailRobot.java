/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : SmtpClient.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Create the group, load the configuration manager and send messages
 -----------------------------------------------------------------------------------
 */

import config.ConfigurationManager;
import model.prank.Prank;
import model.prank.PrankGenerator;
import smtp.SmtpClient;

import java.io.IOException;

public class MailRobot {

   public static void main(String... args) throws IOException {
	  // Load the config
	  ConfigurationManager cm = new ConfigurationManager();

	  PrankGenerator prankGenerator = new PrankGenerator(cm);
	  SmtpClient smtpClient = new SmtpClient(cm);
	  // Generate pranks and send them
	  prankGenerator.pranks().stream().map(Prank::generateMessage).forEach(smtpClient::sendMessage);
   }

}

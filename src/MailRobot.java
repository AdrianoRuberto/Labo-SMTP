/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : MailRobot.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : This class initializes the application. It imports the configurations and
 			   use it to first create a wave of pranks to send using the PrankGenerator and
 			   then send them with the smtp client he created.
 -----------------------------------------------------------------------------------
 */

import config.ConfigurationManager;
import model.prank.Prank;
import model.prank.PrankGenerator;
import smtp.SmtpClient;

import java.io.IOException;

public class MailRobot {

   public static void main(String... args) throws IOException {
	  ConfigurationManager cm = new ConfigurationManager();
	  PrankGenerator prankGenerator = new PrankGenerator(cm);
	  SmtpClient smtpClient = new SmtpClient(cm);

	   // For each generated prank, we create the messages and send them
	  prankGenerator.pranks().stream().map(Prank::generateMessage).forEach(smtpClient::sendMessage);

   }

}

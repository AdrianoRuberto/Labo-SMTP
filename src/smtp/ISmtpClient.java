/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : ISmtpClient.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : This interface represent a SMTP client with the possibility to send an email
 -----------------------------------------------------------------------------------
 */

package smtp;

import model.mail.Message;

import java.io.IOException;

public interface ISmtpClient {
   /**
	* Send a message
	* @param message the message to be send
	* @throws IOException
	*/
   void sendMessage(Message message) throws IOException;
}

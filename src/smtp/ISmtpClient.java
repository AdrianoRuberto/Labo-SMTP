/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : ISmtpClient.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Represents a SMTP client interface which would allow to send emails
 -----------------------------------------------------------------------------------
 */

package smtp;

import model.mail.Message;

import java.io.IOException;

public interface ISmtpClient {
   public void sendMessage(Message message) throws IOException;
}

/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : ISmtpClient.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Représente une interface de client SMTP permettant d'envoyer un email
 -----------------------------------------------------------------------------------
 */

package smtp;

import model.mail.Message;

import java.io.IOException;

public interface ISmtpClient {
   public void sendMessage(Message message) throws IOException;
}

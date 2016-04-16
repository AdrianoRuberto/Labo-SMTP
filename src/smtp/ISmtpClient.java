package smtp;/*
 * Projet : Labo-SMTP
 * Créé le 16.04.2016.
 * Auteur : Adriano Ruberto
 */

import model.mail.Message;

import java.io.IOException;

public interface ISmtpClient {
   public void sendMessage(Message message) throws IOException;
}

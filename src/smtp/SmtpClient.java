/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : SmtpClient.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : Permet d'envoyer un message en utilisant les configurations prédéfinies
 -----------------------------------------------------------------------------------
 */

package smtp;

import config.ConfigurationManager;
import model.mail.Message;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class SmtpClient implements ISmtpClient {

   ConfigurationManager cm;

   public SmtpClient(ConfigurationManager cm) {
	  this.cm = cm;
   }

   @Override
   public void sendMessage(Message message) {
	  try {
		  // Connexion socket
		 Socket socket = new Socket(cm.getSmtpServerAddress(), cm.getSmtpServerPort());
		 PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

		 System.out.println(reader.readLine()); // Consume la première ligne
		 writer.printf("EHLO " + cm.getSmtpServerAddress() + "\r\n");
		 String line = reader.readLine();
		 System.out.println(line);
		 if (!line.startsWith("250-")) throw new RuntimeException("SMTP error");

		 while (line.startsWith("250-")) {
			line = reader.readLine();
			System.out.println(line);
		 }

		 // Sender
		 writer.write("MAIL FROM:<" + message.getFrom() + ">\r\n");
		 writer.flush();
		 System.out.println(reader.readLine());

		 // Recipient
		 for (String to : message.getTo()) {
			writer.write("RCPT TO:<" + to + ">\r\n");
			writer.flush();
			System.out.println(reader.readLine());
		 }

		 // CC
		 for (String s : message.getCc()) {
			writer.write("RCPT TO:<" + s + ">\r\n");
			writer.flush();
			System.out.println(reader.readLine());
		 }

		 for (String s : message.getBcc()) {
			writer.write("RCPT TO:<" + s + ">\r\n");
			writer.flush();
			System.out.println(reader.readLine());
		 }

		 writer.write("DATA\r\n");
		 writer.flush();
		 System.out.println(reader.readLine());
		 writer.write("From: " + message.getFrom());
		 writer.write("\r\nTo: " + message.getTo()[0]);
		 Arrays.stream(message.getTo()).skip(1).forEach(s -> writer.write(", " + s));

		 writer.write("\r\nCc: " + message.getCc()[0]);
		 Arrays.stream(message.getCc()).skip(1).forEach(s -> writer.write(", " + s));
		 writer.write("\r\n");
		 writer.flush();

		 System.out.println(message.getBody());
		 writer.write(message.getBody() + "\r\n.\r\n");
		 writer.flush();
		 System.out.println(reader.readLine());
		 writer.write("QUIT\r\n");
		 writer.flush();
		 writer.close();
		 reader.close();
		 socket.close();
	  } catch (IOException e) {
		 e.printStackTrace();
	  }

   }
}

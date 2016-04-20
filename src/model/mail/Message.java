package model.mail;
/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo-SMTP
 Fichier     : Message.java
 Auteur(s)   : Adriano Ruberto && Matthieu Villard
 Date        : 20.04.2016
 Description : A message object contains the entire information needed to sent an email,
               including the message body and the headers.
 -----------------------------------------------------------------------------------
 */

public class Message {
    // headers
   private String from;
   private String[] to;
   private String[] cc;
   private String[] bcc;
   private String subject;
   private String body;

   public Message() {
	  to = new String[0];
	  cc = new String[0];
	  bcc = new String[0];
   }

    // headers setters and getters
   public String getBody() {
	  return body;
   }

   public void setBody(String body) {
	  this.body = body;
   }

   public String getFrom() {
	  return from;
   }

   public void setFrom(String from) {
	  this.from = from;
   }

   public String[] getBcc() {
	  return bcc;
   }

   public void setBcc(String[] bcc) {
	  this.bcc = bcc;
   }

   public String[] getCc() {
	  return cc;
   }

   public void setCc(String[] cc) {
	  this.cc = cc;
   }

   public String getSubject() {
	  return subject;
   }

   public void setSubject(String subject) {
	  this.subject = subject;
   }

   public String[] getTo() {
	  return to;
   }

   public void setTo(String[] to) {
	  this.to = to;
   }
}

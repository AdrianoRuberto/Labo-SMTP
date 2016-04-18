package model.mail;
/*
 * Projet : Labo-SMTP
 * Créé le 16.04.2016.
 * Auteur : Adriano Ruberto
 */

public class Message {
   private String from;
   private String[] to;
   private String[] cc;
   private String[] bcc;
   private String subject;
   private String body;

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

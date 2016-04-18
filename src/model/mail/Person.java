package model.mail;
/*
 * Projet : Labo-SMTP
 * Créé le 16.04.2016.
 * Auteur : Adriano Ruberto
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
   private String firstName;
   private String lastName;
   private String address;

   public Person(String firstName, String lastName, String address) {
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.address = address;
   }

   public Person(String address) {
	  Pattern pattern = Pattern.compile("(.*)\\.(.*)@");
	  Matcher matcher = pattern.matcher(address);
	  if (!matcher.find()) throw new RuntimeException("The address " + address + " has not the right format");

	  this.address = address;
	  firstName = matcher.group(1);
	  firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1); // Capitalize the first letter
	  lastName = matcher.group(2);
	  lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1); // Capitalize the first letter
   }

   public String getAddress() {
	  return address;
   }

   public String getFirstName() {
	  return firstName;
   }

   public String getLastName() {
	  return lastName;
   }
}

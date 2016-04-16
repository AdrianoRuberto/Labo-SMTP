package config;

/*
 * Projet : Labo-SMTP
 * Créé le 16.04.2016.
 * Auteur : Adriano Ruberto
 */

import model.mail.Message;
import model.mail.Person;

import java.util.List;

public interface IConfigurationManager {
   List<Person> getVictims();
   List<Message> getMessages();
}

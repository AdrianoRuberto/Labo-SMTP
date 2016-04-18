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

	  prankGenerator.pranks().stream().map(Prank::generateMessage).forEach(smtpClient::sendMessage);

   }

}

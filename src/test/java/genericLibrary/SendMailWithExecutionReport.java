package genericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import commonLibrary.SystemConfiguration;

public class SendMailWithExecutionReport extends SystemConfiguration 
{
	//Report is only able to send while you are connected to office network or you need to connect Pulse Secure
	static SimpleDateFormat reportBodyFormatter= new SimpleDateFormat("E, dd MMM yy - HH:mm (z)"); //day, Month date year- Hour:min (TimeZone)
	static Date reportBodyDate = new Date(); 
	static String reportBodyDateFormatter= reportBodyFormatter.format(reportBodyDate);
	static EmailAttachment attachment1 = new EmailAttachment();
	static EmailAttachment attachment2 = new EmailAttachment();
	
	static MultiPartEmail email = new MultiPartEmail();
	
	public static void sendReportThroughMail(String list) 
	{
		attachment2.setPath (newResultDir+"/"+ScreenRecorderManager.passToExtent);
		attachment2.setDisposition(EmailAttachment.ATTACHMENT);
		attachment2.setDescription(ScreenRecorderManager.passToExtent);
		String reportName2 = attachment2.getDescription();
		attachment2.setName(reportName2);
		
		attachment1.setPath (ZipFolder.zipName);
		attachment1.setDisposition(EmailAttachment.ATTACHMENT);
		attachment1.setDescription("Automation Test Artifacts "+reportBodyDateFormatter+".zip");
		String reportName = attachment1.getDescription();
		attachment1.setName(reportName);
		
		email.setHostName("smtp.hermanmiller.com");

		switch (list.toUpperCase()) 
		{ 
			case "ME":
				sendMailToMe();
				break;
			case "ALL":
				sendMailToAll();
				break;
			default: 
				System.out.println("Error String Passed");
		}
	}
	
	public static void sendMailToMe() 
	{
		String senderMail = null, senderName = null;
		String toMail = null, toName = null;
		String ccMail = null, ccName = null;
		try 
		{
			senderMail = LoadProperties.loadObject(applicationFileDir+"MailList.properties","senderMail");
			senderName = LoadProperties.loadObject(applicationFileDir+"MailList.properties","senderName");
			toMail = LoadProperties.loadObject(applicationFileDir+"MailList.properties","toMail");
			toName = LoadProperties.loadObject(applicationFileDir+"MailList.properties","toName");	
			ccMail = LoadProperties.loadObject(applicationFileDir+"MailList.properties","ccMail");
			ccName = LoadProperties.loadObject(applicationFileDir+"MailList.properties","ccName");
			email.setFrom(senderMail, senderName);
			email.addTo(toMail, toName);
			email.addCc(ccMail, ccName);			
			email.setSubject("Automation Test Report on "+reportBodyDateFormatter);
			email.setMsg("Hi,\n\n"+"This is Auto-Generated E-Mail. "
					+ "Please find the attached Execution Artifacts & Recorded-Video"
					+ "\n\nOn Date & Time Stamp : "
					+reportBodyDateFormatter+"\n\nThanks & Regards,\nSoumen Roy");
			email.attach(attachment1);
			email.attach(attachment2);
			email.send();
		}
		catch (Exception e)
		{
			System.out.println("Error Occurs While Sending Email "+ e.getMessage());
		}
	}
	
	public static void sendMailToAll() 
	{
		String senderMail = null, senderName = null, ccMail = null;
		String toMails [] = null;		
		try 
		{
			senderMail = LoadProperties.loadObject(applicationFileDir+"MailList.properties","senderMail");
			senderName = LoadProperties.loadObject(applicationFileDir+"MailList.properties","senderName");
			ccMail = LoadProperties.loadObject(applicationFileDir+"MailList.properties","ccMail");
			toMails = CSVMailListsManager.readLists("EMail");
			
			email.setFrom(senderMail, senderName);
			email.addTo(toMails);
			email.addCc(ccMail);
			
			email.setSubject("Automation Test Report on "+reportBodyDateFormatter);
			email.setMsg("Hi,\n\n"+"This is Auto-Generated E-Mail."
					+ "Please find the attached report."
					+ "\nOn Execution Date & Time Stamp : "
					+reportBodyDateFormatter+"\n\nThanks & Regards,\nSoumen Roy");
			email.attach(attachment1);
			email.attach(attachment2);
			email.send();
		}
		catch (Exception e)
		{
			System.out.println("Error Occurs While Sending Email "+ e.getMessage());
		}
	}
}

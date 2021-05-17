package genericLibrary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CurrentDateTime 
{
	public  DateFormat sdf = new SimpleDateFormat("dd-MM-yy(HH.mm.ss)");
	public  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy(HH.mm.ss)");

	public String getDate()
	{
		Date date = new Date();
		return sdf.format(date);
	}

	public String getCalender()
	{
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}

	public String getLocalDateTime()
	{
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public String getLocalDate()
	{
		LocalDate localDate = LocalDate.now();
		return DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
	}
}

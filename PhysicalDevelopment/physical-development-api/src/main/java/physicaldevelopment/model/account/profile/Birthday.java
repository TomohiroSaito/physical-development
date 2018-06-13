package physicaldevelopment.model.account.profile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Birthday {
	private Date birthday;
	String year;
	String month;
	String day;
	String stringBirthday;

	public Birthday() {}
	public Birthday(String stringYear, String stringMonth, String stringDay) {
		int intYear = Integer.parseInt(stringYear);
		int intMonth = Integer.parseInt(stringMonth);
		int intDay = Integer.parseInt(stringDay);
		this.birthday = new Date(intYear-1900, intMonth-1, intDay);
		this.stringBirthday = new SimpleDateFormat("yyyy'年'MM'月'dd'日'").format(this.birthday);
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthdayString() {
		return stringBirthday;
	}
}

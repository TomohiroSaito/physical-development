package physicaldevelopment.model.account.profile;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Birthday {
	private Date birthday;
	@NotNull(message="必須です。")
	private String year;
	@NotNull(message="必須です。")
	private String month;
	@NotNull(message="必須です。")
	private String day;

	public Birthday() {}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void asBirthday() {
		int intYear = Integer.parseInt(year);
		int intMonth = Integer.parseInt(month);
		int intDay = Integer.parseInt(day);
		this.birthday = new Date(intYear-1900, intMonth-1, intDay);
	}

	public String getBirthdayString() {
		return new SimpleDateFormat("yyyy'年'MM'月'dd'日'").format(this.birthday);
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
}

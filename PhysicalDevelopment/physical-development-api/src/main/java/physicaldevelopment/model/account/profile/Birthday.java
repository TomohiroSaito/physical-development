package physicaldevelopment.model.account.profile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Birthday {
	private Date birthday;
	@Pattern(regexp = "^[0-9]{4}", message = "年は数字4桁で入力してください。")
	@NotBlank(message = "年は必須です。")
	private String year;
	@Pattern(regexp = "^[0-9]{1,2}", message = "月は数字2桁で入力してください。")
	@NotBlank(message = "月は必須です。")
	private String month;
	@Pattern(regexp = "^[0-9]{1,2}", message = "日は数字2桁で入力してください。")
	@NotBlank(message = "日は必須です。")
	private String day;

	public Birthday() {
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void checkFormatDate() {
		// int intYear = Integer.parseInt(year);
		// int intMonth = Integer.parseInt(month);
		// int intDay = Integer.parseInt(day);
		// Date date = new Date(intYear-1900, intMonth-1, intDay);
		String zeroFillMonth = String.format("%02d", Integer.parseInt(month));
		String zeroFillDay = String.format("%02d", Integer.parseInt(day));
		String dateOfBirth = year + "/" + zeroFillMonth + "/" + zeroFillDay;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				.ofPattern("yyyy/MM/dd");
		dateTimeFormatter.format(LocalDate
				.parse(dateOfBirth, dateTimeFormatter));
	}

	public void asBirthday() {
		int intYear = Integer.parseInt(year);
		int intMonth = Integer.parseInt(month);
		int intDay = Integer.parseInt(day);
		this.birthday = new Date(intYear - 1900, intMonth - 1, intDay);
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

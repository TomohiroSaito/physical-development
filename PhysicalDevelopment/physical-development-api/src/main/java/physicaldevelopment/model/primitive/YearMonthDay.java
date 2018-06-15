package physicaldevelopment.model.primitive;

import java.util.Date;

public class YearMonthDay {
	private Date yearMonthDay;
	private String year;
	private String month;
	private String day;

	public YearMonthDay() {}

	public YearMonthDay(Date yearMonthDay) {
		this.yearMonthDay = yearMonthDay;
	}

	public void asYearMonthDay() {
		int intYear = Integer.parseInt(year);
		int intMonth = Integer.parseInt(month);
		int intDay = Integer.parseInt(day);
		this.yearMonthDay = new Date(intYear-1900, intMonth-1, intDay);
	}

	public Date getYearMonthDay() {
		return this.yearMonthDay;
	}

	public void setYearMonthDay(Date yearMonthDay) {
		this.yearMonthDay = yearMonthDay;
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

package calender;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dataServlet")
public class DateTime extends HttpServlet{
	LocalTime lt;
	LocalDate ld;
	@Override
	public void init() {
		lt = LocalTime.now();
		ld = LocalDate.now();
	}
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int hours = lt.getHour();
		int minutes = lt.getMinute();
		int seconds = lt.getSecond();
		int date = ld.getDayOfMonth();
		int monthCount = ld.getMonthValue();
		Month m = ld.getMonth();
		String month = m.toString().substring(0,3);
		DayOfWeek week = ld.getDayOfWeek();
		String day = week.toString().substring(0,3);
		System.out.println(hours+" "+minutes+" "+seconds+" "+date);
		StringBuilder json = new StringBuilder();
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
						json.append("[");
						json.append("{").append("\"seconds\":\"").append(seconds).append("\",");
						json.append("\"minutes\":\"").append(minutes).append("\",");
						json.append("\"hours\":\"").append(hours%12).append("\",");
						json.append("\"day\":\"").append(day).append("\",");
						json.append("\"month\":\"").append(month).append("\",");
						json.append("\"monthCount\":\"").append(monthCount).append("\",");
						json.append("\"year\":\"").append(isLeap(ld.getYear())?"leap":"not").append("\",");
						json.append("\"date\":\"").append(date).append("\"}").append("]");
		String jsonData = new String(json);
		PrintWriter pw = res.getWriter();
		pw.write(jsonData);
		pw.flush();
	}

	private boolean isLeap(int year) {
		if(year%4==0 && (year% 400==0 || year%100!=100))return true;
		return false;
	}
}

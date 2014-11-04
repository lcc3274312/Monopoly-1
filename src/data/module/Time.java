package data.module;

import java.util.Calendar;
import data.global.Game;

public class Time {

  	public static void nextDay() {
  		Game.dateCalendar.add(Calendar.DAY_OF_YEAR,1);
  		Game.date = Game.dateCalendar.getTime();
  	}
  	
  	public static boolean endOfMonth() {
  		return Game.dateCalendar.get(Calendar.DAY_OF_MONTH) == Game.dateCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) ? true : false;
  	}
}

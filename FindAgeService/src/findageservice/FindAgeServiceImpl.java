package findageservice;

import java.util.Calendar;

public class FindAgeServiceImpl implements FindAgeService {

	@Override
	public String findAge(String nic) {

		String year;
		int dayText;
		int day=0;
		int month=0;
		
		if (nic.length() != 10) {
            return "Invalid NIC NO";
        } else if (nic.length() == 10 && ! isNumeric(nic.substring(0, 9))) {
        	return "Invalid NIC NO";
        }else {
            // Year
            if (nic.length() == 10) {
                year = "19" + nic.substring(0, 2);
                dayText = Integer.parseInt(nic.substring(2, 5));
            } else {
                year = nic.substring(0, 4);
                dayText = Integer.parseInt(nic.substring(4, 3));
            }

            if (dayText > 500) {
                dayText = dayText - 500;
            }

            // Day Digit Validation
            if (dayText < 1 && dayText > 366) {
            	return "Invalid NIC NO";
            } else {

                //Month
                if (dayText > 335) {
                    day = dayText - 335;
                    month = 12;
                }
                else if (dayText > 305) {
                    day = dayText - 305;
                    month = 11;
                }
                else if (dayText > 274) {
                    day = dayText - 274;
                    month = 10;
                }
                else if (dayText > 244) {
                    day = dayText - 244;
                    month = 9;
                }
                else if (dayText > 213) {
                    day = dayText - 213;
                    month = 8;
                }
                else if (dayText > 182) {
                    day = dayText - 182;
                    month = 7;
                }
                else if (dayText > 152) {
                    day = dayText - 152;
                    month = 6;
                }
                else if (dayText > 121) {
                    day = dayText - 121;
                    month = 5;
                }
                else if (dayText > 91) {
                    day = dayText - 91;
                    month = 4;
                }
                else if (dayText > 60) {
                    day = dayText - 60;
                    month = 3;
                }
                else if (dayText < 32) {
                    month = 1;
                    day = dayText;
                }
                else if (dayText > 31) {
                    day = dayText - 31;
                    month = 2;
                }
                
            }
            
            int c_year = Calendar.getInstance().get(Calendar.YEAR);
            int c_month = Calendar.getInstance().get(Calendar.MONTH);
            int c_day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            c_month= c_month+1;
            int age_day=0;
            int age_month=0;
            int age_year=0;
            
            int cal_year = Integer.parseInt(year);
            
            if(c_day>=day) {
            	age_day=c_day-day;
            	if(c_month>=month) {
            		age_month=c_month-month;
                	age_year = c_year-cal_year;
                }else {
                	c_year=c_year-1;
                	c_month=c_month+12;
                	age_month=c_month-month;
                	age_year = c_year-cal_year;
                }
            }else {
            	c_month= c_month-1;
            	c_day= c_day+30;
            	age_day=c_day-day;
            	if(c_month>=month) {
            		age_month=c_month-month;
                	age_year = c_year-cal_year;
                }else {
                	c_year=c_year-1;
                	c_month=c_month+12;
                	age_month=c_month-month;
                	age_year = c_year-cal_year;
                }
            }
            
    		return "Age : "+age_year+" (year) "+age_month+" (month) "+age_day+" (day)";
    		
        }
		
	}
		
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

}

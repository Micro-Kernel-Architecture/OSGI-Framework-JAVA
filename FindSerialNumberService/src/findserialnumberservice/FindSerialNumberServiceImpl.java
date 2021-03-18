package findserialnumberservice;

public class FindSerialNumberServiceImpl implements FindSerialNumberService{

	
	@Override
	public String findBirthdy(String nic) {
		
		int dayText;
		
		if (nic.length() != 10) {
          return "Invalid NIC NO";
    } else if (nic.length() == 10 && ! isNumeric(nic.substring(0, 9))) {
     	return "Invalid NIC NO";
      }else {
         // Year
         if (nic.length() == 10) {
             
              dayText = Integer.parseInt(nic.substring(5, 8));
         } else {
             
             return "Invalid NIC NO";
         }
         return "Serial Number from the Record Book:"+dayText;
      }
		
		
//		String year;
//		int dayText;
//		int day=0;
//		int month=0;
//		
//		if (nic.length() != 10) {
//            return "Invalid NIC NO";
//        } else if (nic.length() == 10 && ! isNumeric(nic.substring(0, 9))) {
//        	return "Invalid NIC NO";
//        }else {
//            // Year
//            if (nic.length() == 10) {
//                year = "19" + nic.substring(0, 2);
//                dayText = Integer.parseInt(nic.substring(5, 8));
//            } else {
//                year = nic.substring(0, 4);
//                dayText = Integer.parseInt(nic.substring(4, 3));
//            }
//
//            if (dayText > 500) {
//                dayText = dayText - 500;
//            }
//
//            // Day Digit Validation
//            if (dayText < 1 && dayText > 366) {
//            	return "Invalid NIC NO";
//            } else {
//
//                //Month
//                if (dayText > 335) {
//                    day = dayText - 335;
//                    month = 12;
//                }
//                else if (dayText > 305) {
//                    day = dayText - 305;
//                    month = 11;
//                }
//                else if (dayText > 274) {
//                    day = dayText - 274;
//                    month = 10;
//                }
//                else if (dayText > 244) {
//                    day = dayText - 244;
//                    month = 9;
//                }
//                else if (dayText > 213) {
//                    day = dayText - 213;
//                    month = 8;
//                }
//                else if (dayText > 182) {
//                    day = dayText - 182;
//                    month = 7;
//                }
//                else if (dayText > 152) {
//                    day = dayText - 152;
//                    month = 6;
//                }
//                else if (dayText > 121) {
//                    day = dayText - 121;
//                    month = 5;
//                }
//                else if (dayText > 91) {
//                    day = dayText - 91;
//                    month = 4;
//                }
//                else if (dayText > 60) {
//                    day = dayText - 60;
//                    month = 3;
//                }
//                else if (dayText < 32) {
//                    month = 1;
//                    day = dayText;
//                }
//                else if (dayText > 31) {
//                    day = dayText - 31;
//                    month = 2;
//                }
//                
//            }
//            
//    		return "Birthday : "+year+" / "+month+" / "+day;
//    		
//        }
		
	}
	
	
	
	
	
	@Override
	public String findprovince(int input1) {
		
		String province;
		
		if(input1 == 1) {
			
			
			
			province= "Western Province";
		}
		else if(input1==2){
			province= "Central Province";
		}
		else if(input1==3){
			province= "Southern Province";
		}
		else if(input1==4){
			province= "Northern Province";
		}
		else if(input1==5){
			province= " Eastern Province";
		}
		else if(input1==6){
			province= "North Western Province";
		}
		else if(input1==7){
			province= "North Central Province";
		}
		else if(input1==8){
			province= "Province of Uva";
		}
		else if(input1==9){
			province= "Province of Sabaragahmuwa";
		}
		else {
			province="Error mlitg";
		}
		
		return "Your Province :" + province;
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

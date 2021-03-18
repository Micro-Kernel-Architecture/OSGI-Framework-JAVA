package idnumber;


import findage.FindAgeActivator;

import findbirthday.FindBirthdayActivator;
import findgender.FindGenderActivator;
import findserialnumber.FindSerialNumberActivator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;




public class Activator implements BundleActivator {

	private static BundleContext context;
	
	private ServiceReference findBirthdayServiceReference;
	private ServiceReference findAgeServiceReference;
	private ServiceReference findGenderServiceReference;
	private ServiceReference findSerialNumberServiceReference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		
		findBirthdayServiceReference = context.getServiceReference(FindBirthdayActivator.class.getName());
		FindBirthdayActivator findBirthdayService = (FindBirthdayActivator) context.getService(findBirthdayServiceReference);
		
		findAgeServiceReference = context.getServiceReference(FindAgeActivator.class.getName());
		FindAgeActivator findAgeService = (FindAgeActivator) context.getService(findAgeServiceReference);
		
		findGenderServiceReference = context.getServiceReference(FindGenderActivator.class.getName());
		FindGenderActivator findGenderService = (FindGenderActivator) context.getService(findGenderServiceReference);
		
		findSerialNumberServiceReference = context.getServiceReference(FindSerialNumberActivator.class.getName());
		FindSerialNumberActivator findserialnumberService = (FindSerialNumberActivator) context.getService(findSerialNumberServiceReference);
		
		
		System.out.println("\n---------------------------");
		System.out.println("\nUniversal Converter Started\n");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = "0", choice = "0";
		
		
while (true) {
			
			/*
			 * Main Menu
			 */
			System.out.println("\n---------------------------");
			System.out.println("\n\nPlease select one of the options.\n");
			System.out.println("1. FindBirthdayActivator");
			System.out.println("2. FindAgeActivator");
			System.out.println("3. FindGenderActivator");
			System.out.println("4. FindSerialNumberActivator");
			System.out.println("0. Exit\n");
			
			try {
				System.out.print("Select an option : ");
				choice = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (choice.equals("0"))
				break;

			/*
			 * Checking whether the choice is between 0 - 4.
			 */
			int count = 0;
			for (int i = 0; i < 5; i++) {
				if (choice.equals(Integer.toString(i)))
					count++;
			}

			if (count == 0)
				continue;
			
			/*
			 * Displaying the Sub Menu according to the choice.
			 */
			if (choice.equals("1")) {
				
				findBirthdayService.diplaySubMenu();
				
			} else if (choice.equals("2")) {
				
				findAgeService.diplaySubMenu();
				
			} else if (choice.equals("3")) {
				
			findGenderService.diplaySubMenu();
				
			} else if (choice.equals("4")) {
				
				findserialnumberService.diplaySubMenu();
				
			}
			
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}

package findage;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import findageservice.FindAgeService;

public class FindAgeActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference findAgeServiceReference;
	private ServiceRegistration findAge;
	private FindAgeService findAgeService;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		FindAgeActivator.context = bundleContext;
		
		findAgeServiceReference = context.getServiceReference(FindAgeService.class.getName());
		findAgeService = (FindAgeService) context.getService(findAgeServiceReference);
		
		findAge = context.registerService(this.getClass().getName(), this, null);
		System.out.println("Find Age Started!");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		findAge.unregister();
		System.out.println("Find Age Stopped!");
		FindAgeActivator.context = null;
	}
	
	public void diplaySubMenu() {
		
		System.out.println("\n---------------------------");
		System.out.println("\nFind Age Started\n");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = "0", choice = "0";

		while (true) {

			/*
			 * Sub Menu
			 */
			System.out.println("\n---------------------------");
			System.out.println("\nPlease select one of the options.\n");
			System.out.println("1. Using NIC Number For Find Age");
			System.out.println("0. Back\n");

			try {
				System.out.print("Select an option : ");
				choice = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (choice.equals("0"))
				break;

			/*
			 * Checking whether the choice is between 0-1.
			 */
			int count = 0;
			for (int i = 0; i < 2; i++) {
				if (choice.equals(Integer.toString(i)))
					count++;
			}

			if (count == 0)
				continue;

			try {
				System.out.print("Enter a NIC Number : ");
				input = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			/*
			 * Doing the conversion and displaying the result according to the choice.
			 */
			if (choice.equals("1")) {

				if (input.matches("^[A-Z0-9]+$")) {
					System.out.println(findAgeService.findAge(input));
				} else {
					System.out.println("\nInvalid Input\n");
					continue;
				}

			}

		}
		
	}

}

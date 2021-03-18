package findageservice;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import findageservice.FindAgeService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration findAgeService;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		FindAgeService ageService = new FindAgeServiceImpl();
		findAgeService = context.registerService(FindAgeService.class.getName(), ageService, null);
		System.out.println("Find Birthday Service Service Started!");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		findAgeService.unregister();
		System.out.println("Find Birthday Service Stopped!");
		Activator.context = null;
	}

}

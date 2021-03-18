package findbirthdayservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class FindBirthdayServiceActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration findBirthdayService;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		FindBirthdayServiceActivator.context = bundleContext;
		
		FindBirthdayService birthdayService = new FindBirthdayServiceImpl();
		findBirthdayService = context.registerService(FindBirthdayService.class.getName(), birthdayService, null);
		System.out.println("Find Birthday Service Service Started!");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		findBirthdayService.unregister();
		System.out.println("Find Birthday Service Stopped!");
		FindBirthdayServiceActivator.context = null;
	}

}

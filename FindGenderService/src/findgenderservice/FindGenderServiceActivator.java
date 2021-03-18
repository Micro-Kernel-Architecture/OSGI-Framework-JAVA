package findgenderservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class FindGenderServiceActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration findAgeService;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		FindGenderServiceActivator.context = bundleContext;

		FindGenderService ageService = new FindGenderServiceImpl();
		findAgeService = context.registerService(FindGenderService.class.getName(), ageService, null);
		System.out.println("Find Gender Service Service Started!");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		findAgeService.unregister();
		System.out.println("Find Gender Service Stopped!");
		FindGenderServiceActivator.context = null;
	}

}

package findserialnumberservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class FindSerialNumberServiceActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration findBirthdayService;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		FindSerialNumberServiceActivator.context = bundleContext;
		
		FindSerialNumberService birthdayService = new FindSerialNumberServiceImpl();
		findBirthdayService = context.registerService(FindSerialNumberService.class.getName(), birthdayService, null);
		System.out.println("Find SerialNumber Service Service Started!");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		findBirthdayService.unregister();
		System.out.println("Find SerialNumber Service Stopped!");
		FindSerialNumberServiceActivator.context = null;
	}

}

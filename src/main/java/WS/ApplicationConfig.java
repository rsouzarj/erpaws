package WS;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("recursos")
public class ApplicationConfig extends Application {
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(WS.ERPWS.class);
	}
}

/*
 * Location: C:\Users\diogo\Documents\workspace\others\prod
 * erp\deploy\erp3.war!\WEB-INF\classes\WS\ApplicationConfig.class Java compiler
 * version: 7 (51.0) JD-Core Version: 0.7.1
 */
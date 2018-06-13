package sankutyu.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.addAdditionalTomcatConnectors(ajpConnector());
		return tomcat;
	}

	private Connector ajpConnector() {
		Connector connector = new Connector("org.apache.coyote.ajp.AjpNioProtocol");
		connector.setAttribute("maxThreads", 100);
		connector.setProtocol("AJP/1.3");
		connector.setPort(8009);
		connector.setRedirectPort(8043);
		connector.setURIEncoding("UTF-8");
		return connector;
	}
}

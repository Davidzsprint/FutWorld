package es.urjc.code.dad;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class FutWorldApplication {
	
	private static final Log LOG = LogFactory.getLog(FutWorldApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FutWorldApplication.class, args);
	}
	
	@Bean
	public Config config() {
		Config config = new Config();
		JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		joinConfig.getMulticastConfig().setEnabled(false);
		joinConfig.getTcpIpConfig().addMember( "100.114.244.42" ).addMember( "100.114.216.85" ).setEnabled( true );
		return config;
	}
	
	@Bean
    public CacheManager cacheManager() {	
    	LOG.info("Activating Cache...");	
    	return new ConcurrentMapCacheManager("futworld"); 
	}
}

/**
 * 
 */
package com.imooc.security.core.authorize;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 默认的授权配置管理器
 * 
 * @author zhailiang
 *
 */
@Component
public class ImoocAuthorizeConfigManager implements AuthorizeConfigManager {
	
	@Autowired
	private List<AuthorizeConfigProvider> authorizeConfigProviders;

	@Override
	public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
			authorizeConfigProvider.config(config);
		}
//		config.anyRequest().authenticated();
	}
	
	

}

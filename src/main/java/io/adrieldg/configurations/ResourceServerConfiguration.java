package io.adrieldg.configurations;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableResourceServer
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends GlobalMethodSecurityConfiguration {

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
      return new OAuth2MethodSecurityExpressionHandler();
  }

  @RequestMapping("/me")
  public Map<String, String> me(Principal principal) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("username", principal.getName());
    return map;
  }


}

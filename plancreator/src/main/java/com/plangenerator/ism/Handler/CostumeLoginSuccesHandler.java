package com.plangenerator.ism.Handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @author Irakli Kardava
 */
@Configuration
public class CostumeLoginSuccesHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            return;
        }
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, redirectUrl);

    }

    /**
     *
     * @param authentication
     * @return url depending on
     */
    protected String determineTargetUrl(Authentication authentication) {
        String url = "login?error=true";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<String>();
        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }
        if (roles.contains("ROLE_ADMIN")) {
            url = "/welcome";

        }
        if (roles.contains("ROLE_USER")) {
            url = "user/welcome";

        }
        return url;
    }
}

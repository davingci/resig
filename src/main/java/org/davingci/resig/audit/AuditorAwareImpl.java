
package org.davingci.resig.audit;

import org.apache.shiro.SecurityUtils;
import org.davingci.resig.domain.User;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override

    public Optional<String> getCurrentAuditor() {

        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            User user = (User) subject.getPrincipals().getPrimaryPrincipal();
            return Optional.of(user.getUsername());

        }
        else {
            return Optional.of("system");
        }


    }


}

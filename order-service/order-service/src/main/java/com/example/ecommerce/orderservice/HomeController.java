package com.example.ecommerce.orderservice;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/home")
    @SuppressWarnings("unchecked")
    public String howdy(Model model, Principal principal) {
        OAuth2Authentication authentication = (OAuth2Authentication) principal;
        Map<String, Object> user = (Map<String, Object>) authentication.getUserAuthentication().getDetails();
        model.addAttribute("user", user);
        return "home";
    }
    
    @RequestMapping("/")
    public void home(Device device) {
        if (device.isMobile()) {
            
        } else if (device.isTablet()) {
            
        } else {
                    
        }
    }
    
    @RequestMapping("/")
    public String home(SitePreference sitePreference, Model model) {
        if (sitePreference == SitePreference.NORMAL) {
            
            return "home";
        } else if (sitePreference == SitePreference.MOBILE) {
            
            return "home-mobile";
        } else if (sitePreference == SitePreference.TABLET) {
            
            return "home-tablet";
        } else {
            
            return "home";
        }
    }
}

package com.application.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class SwaggerUIController {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerUIController.class);

    @GetMapping(value = "/")
    public String index() {
        logger.debug("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
}
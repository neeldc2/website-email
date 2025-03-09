package com.website.website_email.config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;

@Component
public class FreeMarkerConfig {
    private Configuration configuration;

    public FreeMarkerConfig() {
        configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates"); // Adjust the path as needed
        configuration.setDefaultEncoding("UTF-8");
    }

    public String processTemplate(String templateName, Object model) throws IOException, TemplateException {
        Template template = configuration.getTemplate(templateName);
        StringWriter writer = new StringWriter();
        template.process(model, writer);
        return writer.toString();
    }
}

package org.xcounter.geoip.routes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Route;

public abstract class UIRoute extends Route
{
    protected Configuration ftl_configuration = new Configuration();
    protected String title = "IP Geolocation free api", description = "", keywords = "ip geolocation, geoip information, geoip api php, geoip api python, geoip api ruby, geoip api java";
    protected LinkedList<HashMap<String, String>> menu = new LinkedList<HashMap<String,String>>();
    protected String current_menu = "/"; 

    protected UIRoute(String path)
    {
        super(path);
        this.ftl_configuration.setClassForTemplateLoading(this.getClass(), "/");

        {
        	HashMap<String, String> item = new HashMap<String, String>();
        	item.put("name", "Home");
        	item.put("url", "/");
        	this.menu.add(item);
        }

        {
        	HashMap<String, String> item = new HashMap<String, String>();
        	item.put("name", "Code Examples");
        	item.put("url", "/example/list/");
        	this.menu.add(item);
        }
        
        {
        	HashMap<String, String> item = new HashMap<String, String>();
        	item.put("name", "About");
        	item.put("url", "/about/");
        	this.menu.add(item);
        }

    }

    protected Object renderLayout(String content)
    {
        try{
            Template template = this.ftl_configuration.getTemplate("layout.ftl");
            StringWriter sw = new StringWriter();
            HashMap valuesMap = new HashMap();
            valuesMap.put("content", content);
            valuesMap.put("menu", this.menu);
            valuesMap.put("menu_selected", this.current_menu);
            valuesMap.put("title", this.title);
            valuesMap.put("description", this.description);
            valuesMap.put("keywords", this.keywords);
            template.process(valuesMap, sw);
            return sw;
        }catch (TemplateException e) {
            halt(500);
        }catch (IOException e) {
            halt(500);
        }

        return null;
    }

}

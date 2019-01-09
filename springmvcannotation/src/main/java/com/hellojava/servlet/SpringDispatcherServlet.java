package com.hellojava.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.springframework.web.servlet.DispatcherServlet;

@WebServlet(urlPatterns= {"/"},initParams= {@WebInitParam(name="contextClass",value="org.springframework.web.context.support.AnnotationConfigWebApplicationContext"),
			@WebInitParam(name="contextConfigLocation",value="com.hellojava.config.SpringConfiuration")}
			,loadOnStartup=1)
public class SpringDispatcherServlet extends DispatcherServlet {

}

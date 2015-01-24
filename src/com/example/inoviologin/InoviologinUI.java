package com.example.inoviologin;

import javax.servlet.annotation.WebServlet;

import org.vaadin.jonatan.contexthelp.ContextHelp;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("inoviologin")
@JavaScript("http://www.google.com/recaptcha/api/js/recaptcha_ajax.js")
public class InoviologinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = InoviologinUI.class, widgetset = "com.example.inoviologin.widgetset.InoviologinWidgetset")
	public static class Servlet extends VaadinServlet {
	}
	
	final ContextHelp contextHelp = new ContextHelp();
	//ContextHelp
	@Override
	protected void init(VaadinRequest request) {
		final CssLayout layout = new CssLayout();
		layout.addStyleName("inbody");
		contextHelp.extend(this);
		
		CssLayout header = new CssLayout();
		header.setId("helpers");
		
		//RegistrationPage loginPage = new RegistrationPage(header);
		LoginCaptchaForm loginPage = new LoginCaptchaForm(header);
		//LoginPage loginPage = new LoginPage(header);
		
		layout.addComponent(header);
		layout.addComponent(loginPage);

	    
		setContent(layout);
	}
	public ContextHelp getContextHelp() {
		return contextHelp;
	}
	
	

}
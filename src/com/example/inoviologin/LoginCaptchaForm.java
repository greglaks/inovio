package com.example.inoviologin;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.wcs.wcslib.vaadin.widget.recaptcha.ReCaptcha;
import com.wcs.wcslib.vaadin.widget.recaptcha.shared.ReCaptchaOptions;

public class LoginCaptchaForm extends CssLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8365261330523016391L;
	private CssLayout header;

	public LoginCaptchaForm(CssLayout header){
		this.header = header;
		addStyleName("loginpage");
		initHeader();
		initContents();
	}

	private void initHeader() {
		Link link = new Link("Podora", null);
		link.addStyleName("loginlink");
		header.addComponent(link);		
	}

	private void initContents() {
		ReCaptcha captcha = new ReCaptcha("6Lfv5OoSAAAAAPEbWhNB0ERopfQpRxr8_5yncOmg","6Lfv5OoSAAAAAHa4zmExf6w2ja3vm-8ABKgyepq-",
			    new ReCaptchaOptions() {{
			        theme = "blackglass";
			    }}
		);
		captcha.addStyleName("distancebottom");
		CssLayout stroke = new CssLayout();
		stroke.addStyleName("stroke");
		stroke.addStyleName("leftdistance");
		
		
		Image lock = new Image();
		lock.setSource(new ThemeResource("images/lock.png"));
		lock.setId("lock");
		stroke.addComponent(lock);
		
		Image logo = new Image();
		logo.setSource(new ThemeResource("images/Logo.png"));
		logo.setId("logo");
		stroke.addComponent(logo);
		
		Label message = new Label();
		message.addStyleName("loginlabel");
		message.setContentMode(ContentMode.HTML);
		message.setValue("Přihlášení do"
						+"<br><strong>inovio365</strong>");
		stroke.addComponent(message);
		stroke.addComponent(captcha);
		
		TextField emailField = new TextField();
		emailField.setInputPrompt("Přihlašovací email");
		emailField.addStyleName("loginfield");
		//stroke.addComponent(emailField);
		
		PasswordField passwordField = new PasswordField();
		passwordField.addStyleName("loginfield");
		//stroke.addComponent(passwordField);
		
		Button loginButton = new Button("Login");
		
		MyLoginForm loginForm = new MyLoginForm();
		CssLayout loginContent = (CssLayout) loginForm.createContent(emailField, passwordField, loginButton);
		stroke.addComponent(loginForm);
		
		CssLayout container = new CssLayout();
		container.addStyleName("stbottomcontainer");
		
		Label label2 = new Label("Zapoměl jste heslo?");
		label2.addStyleName("lab2");
		container.addComponent(label2);
		
		Link emailLink = new Link("Zaslat na email", null);
		emailLink.addStyleName("loginlink");
		container.addComponent(emailLink);
		
		stroke.addComponent(container);
		
		addComponent(stroke);
		
		
	}
	
	
}

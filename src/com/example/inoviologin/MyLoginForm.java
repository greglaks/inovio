package com.example.inoviologin;

import com.ejt.vaadin.loginform.LoginForm;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class MyLoginForm extends LoginForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1406465881619218479L;

	@Override
	protected Component createContent(TextField userNameField,
			PasswordField passwordField, Button loginButton) {
		CssLayout loginForm = new CssLayout();
		
		userNameField.addStyleName("loginfield");
		userNameField.addStyleName("textform");
		userNameField.addStyleName("nocaption");
		
		passwordField.addStyleName("loginfield");
		passwordField.addStyleName("nocaption");
		passwordField.addStyleName("textform");
		
		CheckBox checkBox = new CheckBox("Pamatujte si mě na tomhle počítači");
		checkBox.addStyleName("logincheckbox");
		
		loginButton.setPrimaryStyleName("loginsubmit");
		
		loginForm.addComponent(userNameField);
		loginForm.addComponent(passwordField);
		loginForm.addComponent(checkBox);
		loginForm.addComponent(loginButton);
		return loginForm;
	}

	@Override
	protected void login(String userName, String password) {
		// TODO Auto-generated method stub

	}

}


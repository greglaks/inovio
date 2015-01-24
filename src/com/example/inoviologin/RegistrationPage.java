package com.example.inoviologin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.vaadin.jonatan.contexthelp.ContextHelp;

import com.vaadin.annotations.JavaScript;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.wcs.wcslib.vaadin.widget.recaptcha.ReCaptcha;
import com.wcs.wcslib.vaadin.widget.recaptcha.shared.ReCaptchaOptions;
@JavaScript("http://www.google.com/recaptcha/api/js/recaptcha_ajax.js")
public class RegistrationPage extends CssLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3808310050271014927L;
	private CssLayout header;
	private ContextHelp contextHelp;

	public RegistrationPage(CssLayout header){
		this.header = header;
		contextHelp = ((InoviologinUI) UI.getCurrent()).getContextHelp();
		contextHelp.setHideOnBlur(false);
		initHeader();
		createContents();
	}

	private void createContents() {
		CssLayout captionSection = createCaptionSection();
		addComponent(captionSection);
		
		CssLayout l = new CssLayout();
		l.addStyleName("registrationpage");
		CssLayout formSection = createFormSection();
		l.addComponent(formSection);
		addComponent(l);
	}

	private CssLayout createFormSection() {
		CssLayout layout = new CssLayout();
		
		layout.addStyleName("stroke");
		layout.addStyleName("centeralignment");
		
		Image logo = new Image();
		logo.addStyleName("rplogo");
		logo.setSource(new ThemeResource("images/Logo.png"));
		layout.addComponent(logo);
		
		TextField field1 = new TextField("Jméno a Přijimení:");
		field1.setImmediate(true);
		field1.addStyleName("loginfield");
		field1.addStyleName("textform");
		contextHelp.addHelpForComponent(field1, "Error");
		field1.addValueChangeListener(new RegistrationFieldValidator("Error", field1));
		layout.addComponent(field1);
		
		TextField field2 = new TextField("Firma:");
		field2.setImmediate(true);
		field2.addStyleName("loginfield");
		field2.addStyleName("textform");
		contextHelp.addHelpForComponent(field2, "Error");
		field2.addValueChangeListener(new RegistrationFieldValidator("Error", field2));
		layout.addComponent(field2);
		
		TextField field3 = new TextField("Email:");
		field3.setImmediate(true);
		field3.addStyleName("loginfield");
		field3.addStyleName("textform");
		contextHelp.addHelpForComponent(field3, "Error");
		field3.addValueChangeListener(new RegistrationFieldValidator("Error", field3));
		layout.addComponent(field3);
		
		PasswordField pfield1 = new PasswordField("Heslo:");
		pfield1.setImmediate(true);
		pfield1.addStyleName("loginfield");
		pfield1.addStyleName("textform");
		contextHelp.addHelpForComponent(pfield1, "Error");
		pfield1.addValueChangeListener(new RegistrationFieldValidator("Error", pfield1));
		layout.addComponent(pfield1);
		
		PasswordField pfield2 = new PasswordField("Potvrďte heslo:");
		pfield2.setImmediate(true);
		pfield2.addStyleName("loginfield");
		pfield2.addStyleName("textform");
		contextHelp.addHelpForComponent(pfield2, "Error");
		pfield2.addValueChangeListener(new RegistrationFieldValidator("Error", pfield2));
		layout.addComponent(pfield2);
		
		OptionGroup option = new OptionGroup("Jsme:");
		option.addStyleName("rgoptiongroup");
		option.addItem(" Běžná firma");
		option.addItem("Účetní kancelář");
		layout.addComponent(option);
		
		ReCaptcha captcha = new ReCaptcha("6Lfv5OoSAAAAAPEbWhNB0ERopfQpRxr8_5yncOmg","6Lfv5OoSAAAAAHa4zmExf6w2ja3vm-8ABKgyepq-",
			    new ReCaptchaOptions() {{
			        theme = "blackglass";
			    }}
			);
//		Label captcha = new Label();
//		captcha.setValue("<div class='g-recaptcha' data-sitekey='6LetGf8SAAAAANVT9SD9EnAxJ0Xr7IiFG4VlEjpB'></div>");
//		captcha.setContentMode(ContentMode.HTML);
//		captcha.addStyleName("centeralignment");
		layout.addComponent(captcha);		

		Button submitButton = new Button("Zdarma založit účet");
		submitButton.setPrimaryStyleName("loginsubmit");
		layout.addComponent(submitButton);
		
		CssLayout container = new CssLayout();
		container.addStyleName("stbottomcontainer");
		
		Label label2 = new Label("Pokud potřebujte jeden účet pro více vašich firem, ");
		label2.addStyleName("lab2");
		container.addComponent(label2);
		
		Link emailLink = new Link("kontaktujte nás", null);
		emailLink.addStyleName("loginlink");
		container.addComponent(emailLink);
		layout.addComponent(container);
		
		
		
		return layout;
	}

	private CssLayout createCaptionSection() {
		CssLayout layout = new CssLayout();
		layout.addStyleName("rpcaptsec");
		
		Label l1 = new Label("První jednoduchá cloudová aplikace na sledování ekonomiky firmy pro malé firmy a OSVOČ.");
		l1.addStyleName("rpl1");
		layout.addComponent(l1);
		
		Label l2 = new Label();
		l2.setContentMode(ContentMode.HTML);
		l2.setId("rppoint");
		l2.setValue("<ul> "
				  + "<li><strong>Zdarma </strong> pro Vás i vaše kolegy a bez závazku</li>"
				  + "<li>Ať jste účetní nebo běžná firma</li>"
				  + "<li>Jenom vyplňte formulář a uvítáme vás na palubě :)!</li>"
			   	  + "</ul>");
		layout.addComponent(l2);
		return layout;
	}

	private void initHeader() {
		Link link = new Link("Podora", null);
		link.addStyleName("loginlink");
		header.addComponent(link);
	
		Label l = new Label("|");
		l.addStyleName("lseparator");
		header.addComponent(l);
		
		Link login = new Link("Login", null);
		login.addStyleName("loginlink");
		header.addComponent(login);		
		
	}
	
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Masukan angka:");
		String t = input.next();
		String[] a = t.split("");
		for(int i=(a.length-1); i>=1; i--){
			System.out.println("Angka: "+a[i]);
		}
	}
	
	public class RegistrationFieldValidator implements ValueChangeListener{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String msg;
		private AbstractTextField field;

		public RegistrationFieldValidator(String msg, AbstractTextField field){
			this.msg = msg;
			this.field = field;
		}

		@Override
		public void valueChange(ValueChangeEvent event) {
			
			String text = field.getValue();
			contextHelp.hideHelp();
			field.removeStyleName("errorfield");
			if(text.equals("")){
				contextHelp.showHelpFor(field);
				field.addStyleName("errorfield");
			}
			
		}
		
	}
}

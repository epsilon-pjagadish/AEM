package com.citraining.core.mail.impl;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citraining.core.config.EmailConfiguration;
import com.citraining.core.mail.MailService;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
/**
 * 
 * @author Phool Chandra
 *	factory=true for configuration factory same service used for multiple configration such as AEM logging
 */
@Component (service = MailService.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate (ocd = EmailConfiguration.class,factory=true)
public class MailServiceImpl implements MailService {

	private EmailConfiguration config;

	@Reference
	private MessageGatewayService messageGatewayService;

	@Reference
	private ResourceResolverFactory resolverFactory;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Activate
	protected void activate(EmailConfiguration config) {
		this.config = config;
	}
@Override
	public void sendMail(String message) {
		try{
			MessageGateway<Email> messageGateway;
			Email email = new SimpleEmail();
			email.addTo(config.getAddress());
			email.setSubject(config.getSubjectValues());
			email.setFrom(config.getFromEmailAdd());
			email.setMsg(message);
			messageGateway = messageGatewayService.getGateway(Email.class);
			messageGateway.send(email);
		} catch (Exception exception){
			logger.error("Exception{}",exception);
		}
	}
}

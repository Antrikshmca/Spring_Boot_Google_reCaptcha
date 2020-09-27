package com.antriksh.springboot.google.reCaptcha.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.antriksh.springboot.google.reCaptcha.model.CaptchaResponse;

@Component
public class CaptchaValidator {

	@Autowired
	private RestTemplate rt; 
	public boolean isValid(String captcha) {
		String url = "https://www.google.com/recaptcha/api/siteverify";
		String params = "?secret=6LcXAtEZAAAAAGh2D6NZhM3GkaZjRImXmGKivPhp&response=" + captcha;
		
		CaptchaResponse resp = rt.postForObject(url + params, null, CaptchaResponse.class);
		return resp.isSuccess();
	}
}

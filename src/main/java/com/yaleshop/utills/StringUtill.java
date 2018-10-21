package com.yaleshop.utills;

import com.yaleshop.contant.StringContants;

public class StringUtill {
	public static boolean checkEmail(String email) {
		return email.matches(StringContants.StringRegex.EMAIL_CONTANT);
	}

}

package kr.co.freeism;

import org.junit.Test;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * @author freeism
 * @since 15. 4. 24.
 */
public class PhoneNumber {
	public void test() throws NumberParseException {
		String numberStr = "01012347777";

		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		Phonenumber.PhoneNumber proto = phoneUtil.parse(numberStr, "KR");

		System.out.println(phoneUtil.format(proto, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL));
		System.out.println(phoneUtil.format(proto, PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
		System.out.println(phoneUtil.format(proto, PhoneNumberUtil.PhoneNumberFormat.E164));
		System.out.println(phoneUtil.formatOutOfCountryCallingNumber(proto, "KR"));

		boolean isValid = phoneUtil.isValidNumber(proto); // returns true
		System.out.println(isValid);
	}
}

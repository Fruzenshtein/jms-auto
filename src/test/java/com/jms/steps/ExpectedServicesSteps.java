package com.jms.steps;

import static org.junit.Assert.*;

import com.jms.pages.ExpectedServicesPopup;
import com.jms.pages.elements.ExpectedServiceOption;
import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.ReportingService;
import com.jms.pages.elements.VendorService;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ExpectedServicesSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	private ExpectedServicesPopup expectedServicesPopup() {
		return getPages().currentPageAt(ExpectedServicesPopup.class);
	}
	
	@Step
	public void clickVendorServiceIconSection(VendorService vendor) {
		expectedServicesPopup().clickVendorServiceIcon(vendor);
	}
	
	@Step
	public void clickVendorTBDIconSection(VendorService vendor) {
		expectedServicesPopup().clickVendorTBDIcon(vendor);
	}
	
	@Step
	public void isServiceIconActivated(VendorService vendor, boolean is) {
		assertTrue(expectedServicesPopup().isServiceIconActivated(vendor, is));
	}
	
	@Step
	public boolean statusOfServiceIcon(VendorService vendor) {
		return expectedServicesPopup().statusServiceIcon(vendor);
	}
	
	@Step
	public void isAsapCheckBox(boolean is) {
		assertTrue("ASAP check box was in inccorrect state", 
				expectedServicesPopup().isAsapCheckBox(is));
	}
	
	@Step
	public void isCheckBoxChecked(ExpectedServiceOption service, boolean is) {
			assertTrue(expectedServicesPopup().isServiceCheckBoxChecked(service, is));
	}
	
	@Step
	public void isCurrentDelivery(String selectedItem) {
		assertTrue(expectedServicesPopup().getCurrentDelivery().contains(selectedItem));
	}
	
	@Step
	public void selectDelivery(String delivery) {
		expectedServicesPopup().selectDelivery(delivery);
	}
	
	@Step
	public void isExpectedServicesSection(ExpectedServiceSection section, boolean enabled) {
		assertTrue(section.getSection()+" section wasn't in expected state.", 
				expectedServicesPopup().isExpectedServicesSection(section, enabled));
	}

	@Step
	public void clickUpdate() {
		expectedServicesPopup().clickUpdate();
	}
	
	@Step
	public void clickReportingServiceCheckBox(ExpectedServiceOption service, int order) {
		expectedServicesPopup().clickReportingServiceCheckBox(service, order);
	}
	
	@Step
	public void isDisplayedReportingServiceCheckBox(ReportingService service, boolean is) {
		assertEquals(is, expectedServicesPopup().isDisplayedReportingServiceCheckBox(service));
	}
	
	@Step
	public void setReporterInstructions(String text) {
		expectedServicesPopup().setReporterInstructions(text);
	}
	
	@Step
	public void setVideographerInstructions(String text) {
		expectedServicesPopup().setVideographerInstructions(text);
	}
	
	@Step
	public void setNumberOfLeptops(String number) {
		expectedServicesPopup().setNumberOfLeptops(number);
	}

	@Step
	public void clickAddEmailLink() {
		expectedServicesPopup().clickAddEmailLink();
	}
	
	@Step
	public void addEmail(String email) {
		expectedServicesPopup().addEmail(email);
	}
	
	@Step
	public void addEmailInVeideoStream(String email) {
		expectedServicesPopup().addEmailInVeideoStream(email);
	}
	
	@Step
	public void selectConferenceLocation(int index) {
		expectedServicesPopup().selectConferenceLocation(index);
	}
	
	@Step
	public void clickAddLocationLink() {
		expectedServicesPopup().clickAddLocationLink();
	}
	
	@Step
	public void setIP(String ip) {
		expectedServicesPopup().setIP(ip);
	}
	
	@Step
	public void setISDN(String isdn) {
		expectedServicesPopup().setISDN(isdn);
	}
	
	@Step
	public void setItContact(String itContact) {
		expectedServicesPopup().setItContact(itContact);
	}
	
	@Step
	public void setPhoneConfServices(String phone) {
		expectedServicesPopup().setPhoneConfServices(phone);
	}
	
	@Step
	public void setNotes(String notes) {
		expectedServicesPopup().setNotes(notes);
	}
	
	@Step
	public void setNumberOfCameos(String number) {
		expectedServicesPopup().setNumberOfCameos(number);
	}
	
	@Step
	public void addEmailConfServSection(String email) {
		expectedServicesPopup().addEmailConfServSection(email);
	}
	
	@Step
	public void clickAddLanguageLink() {
		expectedServicesPopup().clickAddLanguage();
	}
}

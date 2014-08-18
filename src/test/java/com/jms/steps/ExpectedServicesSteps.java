package com.jms.steps;

import static org.junit.Assert.*;

import java.util.List;

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
	public List<String> getDeliveryOptions() {
		return expectedServicesPopup().getDeliveryOptions();
	}
	
	@Step
	public void assertDeliveryDates(String[] dates) {
		List<String> realDates = expectedServicesPopup().getDeliveryOptions();
		for (String date : dates) {
			assertTrue("The Delivery list doesn't contain: "+date, realDates.contains(date));
		}
	}
	
	@Step
	public void selectDelivery2(int index) {
		expectedServicesPopup().selectDelivery2(index);
	}
	
	@Step
	public void isExpectedServicesSection(ExpectedServiceSection section, boolean enabled) {
		assertTrue(section.getSection()+" section wasn't in expected state.", 
				expectedServicesPopup().isExpectedServicesSection(section, enabled));
	}
	
	@Step
	public void clickAgencyByIndex(int index) {
		expectedServicesPopup().clickAgencyByIndex(index);
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
	public void clickVideoConferenceNeededCheckBox(int order) {
		expectedServicesPopup().clickVideoConferenceNeededCheckBox(order);
	}
	
	@Step
	public void clickInitiatesConferenceCheckBox(int order) {
		expectedServicesPopup().clickInitiatesConferenceCheckBox(order);
	}
	
	@Step
	public void clickTSGProvidingBridgeCheckBox(int order) {
		expectedServicesPopup().clickTSGProvidingBridgeCheckBox(order);
	}
	
	@Step
	public void clickCameoCheckBox(int order) {
		expectedServicesPopup().clickCameoCheckBox(order);
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
	public void clickAddEmailLink(int index) {
		expectedServicesPopup().clickAddEmailLink(index);
	}
	
	@Step
	public void clickAddEmailLinkInStreamingSection(int index) {
		expectedServicesPopup().clickAddEmailLinkInStreamingSection(index);
	}
	
	@Step
	public void addEmail(int index, String email) {
		expectedServicesPopup().addEmail(index,email);
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
	public void setIP(int index, String ip) {
		expectedServicesPopup().setIP(index, ip);
	}
	
	@Step
	public void setISDN(int index, String isdn) {
		expectedServicesPopup().setISDN(index, isdn);
	}
	
	@Step
	public void setItContact(int index, String itContact) {
		expectedServicesPopup().setItContact(index, itContact);
	}
	
	@Step
	public void setPhoneConfServices(int index, String phone) {
		expectedServicesPopup().setPhoneConfServices(index, phone);
	}
	
	@Step
	public void setNotes(int index, String notes) {
		expectedServicesPopup().setNotes(index, notes);
	}
	
	@Step
	public void setNumberOfCameos(String number, int index) {
		expectedServicesPopup().setNumberOfCameos(number, index);
	}
	
	@Step
	public void addEmailConfServSection(String email, int index) {
		expectedServicesPopup().addEmailConfServSection(email, index);
	}
	
	@Step
	public void clickAddLanguageLink() {
		expectedServicesPopup().clickAddLanguage();
	}
	
	@Step
	public void clickChangeRecommendationButton() {
		expectedServicesPopup().clickChangeRecommendationButton();
	}
	
	@Step
	public void goToFirmTab(int index) {
		expectedServicesPopup().goToFirmTab(index);
	}
	
	@Step
	public void checkExhibitASAP() {
		expectedServicesPopup().checkExhibitASAP();
	}
	
	@Step
	public void clickOnVendorSection(int index) {
		expectedServicesPopup().clickOnVendorSection(index);
	}
	
	@Step
	public void removeLocation(int index) {
		expectedServicesPopup().removeLocation(index);
	}
	
	@Step

	public void chooseRoomTSGLocation(int indexChkbx, int indexSelect) {
		expectedServicesPopup().chooseRoomTSGLocation(indexChkbx, indexSelect);
	}
	public void selectLanguage(int index, int languageIndex) {
		expectedServicesPopup().selectLanguage(index, languageIndex);
	}
	
	@Step
	public void selectAppliedWitness(int index, int witnessIndex) {
		expectedServicesPopup().selectAppliedWitness(index, witnessIndex);
	}
	
	@Step
	public void deleteLanguage(int index) {
		expectedServicesPopup().deleteLanguage(index);

	}
}

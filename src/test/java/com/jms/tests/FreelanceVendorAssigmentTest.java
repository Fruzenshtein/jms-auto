package com.jms.tests;

import org.junit.Test;

import com.jms.pages.elements.ActionLink;
import com.jms.requirements.VendorWorkflowStory;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

@Story(VendorWorkflowStory.class)
public class FreelanceVendorAssigmentTest extends BasicTest {
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Steps
	public ExpectedServicesSteps expectedServicesSteps;
	
	private String jobId = "1713";

	@Test
	@Screenshots(onlyOnFailures = true)
	public void recommendedVendorReassignment() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickActionMenuLink(1, ActionLink.RECOMMEND_ANOTHER_VEND);
		
		String currentVandor = jobDetailSteps.getVendorNameInManageModule(1);
		
		globalSteps.waitUntilTextDisappear(currentVandor);
		
	}

}

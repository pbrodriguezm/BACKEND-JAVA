package com.pbrm.backend.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("testComponent")
public class TestComponent {

	private static final Log LOG =  LogFactory.getLog(TestComponent.class);
	public void test() {
		LOG.info("ejemplo control");
	}

}

package com.taven.app.spring;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taven.UnitTestBase;

public class SpringDemo1Test extends UnitTestBase {

	@Autowired
	private Hello hello;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void showMsgTest() {

		Assert.assertNotNull(hello);

	}

	@Test
	public void otherTest() {

		fail("Not yet implemented");
	}

}

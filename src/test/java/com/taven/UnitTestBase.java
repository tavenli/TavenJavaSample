package com.taven;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({ "classpath:applicationContext-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UnitTestBase {

}

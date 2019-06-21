package com.usa.federal.gov.ssa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.usa.federal.gov.ssa.controller.SsaController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsnProjectApplicationTests {
	@Autowired
	SsaController controller;

	@Test
	public void testSomething() {
	}
}

package com.chengqhuster;

import com.chengqhuster.service.ComputeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {

	@Autowired
	ComputeService computeService;

	@Test
	public void testAdd() throws Exception {
		Assert.assertEquals("compute-service:add", new Integer(3), computeService.add(1, 2));
	}

}

package com.chengqhuster;

import com.chengqhuster.service.BlogProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Chapter211Application.class})
public class Chapter211ApplicationTests {

	private static final Log log = LogFactory.getLog(Chapter211ApplicationTests.class);

	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void test1() throws Exception {
		Assert.assertEquals("chengqhuster", blogProperties.getName());
		Assert.assertEquals("Spring Boot", blogProperties.getTitle());
		//TODO properties文件编码不一致
		//Assert.assertEquals("chengqhuster正在努力学习Spring Boot", blogProperties.getDesc());

		log.info("随机数测试输出：");
		log.info("随机字符串 : " + blogProperties.getValue());
		log.info("随机int : " + blogProperties.getNumber());
		log.info("随机long : " + blogProperties.getBignumber());
		log.info("随机10以下 : " + blogProperties.getTest1());
		log.info("随机10-20 : " + blogProperties.getTest2());

	}

}

package workingtalent.mailDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailDemoApplicationTests {

	@Autowired
	MailDemoApplication mailDemoApplication;
	
	@SuppressWarnings("deprecation")
	@Test
	public void contextLoads() {
		Assert.assertEquals(2, mailDemoApplication.telOp(1,1));
	}

}

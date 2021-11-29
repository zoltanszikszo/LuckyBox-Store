package zoltanszikszo.LuckyBox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import zoltanszikszo.LuckyBox.web.LuckyBoxController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LuckyBoxApplicationTests {

	@Autowired
	private LuckyBoxController luckyboxcontroller;

	@Test
	void contextLoads() throws Exception{
		assertThat(luckyboxcontroller).isNotNull();
	}

}

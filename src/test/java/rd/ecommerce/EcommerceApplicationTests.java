package rd.ecommerce;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcommerceApplicationTests {

	@Test
	public void testarSeEVerdadeiro() {
		Boolean verdadeiro = true;
		Assertions.assertThat(verdadeiro).isEqualTo(true);
	}
}

package br.com.helpdev.workshopunittest.business;

import br.com.helpdev.workshopunittest.service.SerasaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class FinanceSimulateBusinessTest {

  @MockBean
  private SerasaService serasaService;

  @Autowired
  private FinanceSimulateBusiness financeSimulateBusiness;

  @Test
  void test() {
    //TODO
  }

}
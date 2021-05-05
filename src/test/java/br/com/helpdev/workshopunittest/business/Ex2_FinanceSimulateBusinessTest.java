package br.com.helpdev.workshopunittest.business;

import br.com.helpdev.workshopunittest.business.model.SimulationData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex2_FinanceSimulateBusinessTest {

  @Autowired
  private FinanceSimulateBusiness financeSimulateBusiness;

  @Test
  void shouldBeAssertTheCorrectValueForFinanceSimulate() {

    // - If you dont mock the external dependencies (SerasaService) the result turns random

    final var simulateData = new SimulationData("22233322211", 1_000L, 100_000L, 100L);

    final var result = financeSimulateBusiness.simulate(simulateData);

    Assertions.assertEquals(1100.0, result.getParcelValue());

  }

}
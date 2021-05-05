package br.com.helpdev.workshopunittest.business;

import br.com.helpdev.workshopunittest.business.model.SimulationData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Using Mocks and how to solve mock static methods
 */
@SpringBootTest
class Ex2_FinanceSimulateBusinessTest {

  // - Yes, you can't alter this value!
  private static final String DOCUMENT__DONT_ALTER_THIS_VALUE = "2424";

  @Autowired
  private FinanceSimulateBusiness financeSimulateBusiness;

  @Test
  void shouldBeAssertTheCorrectValueForFinanceSimulate() {

    // - If you dont mock the external dependencies (SerasaService) the result turns random

    final var simulateData = new SimulationData(DOCUMENT__DONT_ALTER_THIS_VALUE, 1_000L, 100_000L, 100L);

    final var result = financeSimulateBusiness.simulate(simulateData);

    Assertions.assertEquals(1100.0, result.getParcelValue());

  }

}
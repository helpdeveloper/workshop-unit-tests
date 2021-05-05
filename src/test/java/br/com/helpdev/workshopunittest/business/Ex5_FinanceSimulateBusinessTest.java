package br.com.helpdev.workshopunittest.business;

import br.com.helpdev.workshopunittest.business.model.SimulationData;
import br.com.helpdev.workshopunittest.service.SerasaService;
import br.com.helpdev.workshopunittest.service.objects.SerasaDebits;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

// - Why do you force the Spring Runner?. This becomes an integrated test
@SpringBootTest
class Ex5_FinanceSimulateBusinessTest {

  @MockBean
  private SerasaService serasaService;

  @Autowired
  private FinanceSimulateBusiness financeSimulateBusiness;

  @BeforeEach
  void setup() {
    // - Don't use reflection.
    // - Don't define a default values end behaviors here.

    ReflectionTestUtils.setField(financeSimulateBusiness, "personCalcValue", 100L);
    ReflectionTestUtils.setField(financeSimulateBusiness, "companyCalcValue", 20L);

    Mockito.when(serasaService.getDebits(ArgumentMatchers.anyString())).thenReturn(Collections.emptyList());
  }

  // what is the value of this?
  @Test
  void testValues() {
    Assertions.assertEquals(100, financeSimulateBusiness.getPersonCalcValue());
    Assertions.assertEquals(20L, financeSimulateBusiness.getCompanyCalcValue());
  }

  @Test
  void testUserHasDebits() {
    // - Don't need use stubs! use mocks
    final var simulateData = new SimulationData("123", 10L, 10L, 10L);
    final var debits = Collections.singletonList(new SerasaDebits(10L));

    Mockito.when(serasaService.getDebits(simulateData.getDocument()))
        .thenReturn(debits);

    Assertions.assertThrows(SecurityException.class, () -> financeSimulateBusiness.simulate(simulateData));
  }

}
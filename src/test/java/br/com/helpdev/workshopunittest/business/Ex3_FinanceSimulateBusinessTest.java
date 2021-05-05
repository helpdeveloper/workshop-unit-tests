package br.com.helpdev.workshopunittest.business;

import br.com.helpdev.workshopunittest.business.model.SimulationData;
import br.com.helpdev.workshopunittest.service.SerasaService;
import br.com.helpdev.workshopunittest.service.objects.SerasaDebits;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Refactoring tests to use the AAA standard
 */
@SpringBootTest
class Ex3_FinanceSimulateBusinessTest {

  @MockBean
  private SerasaService serasaService;

  @InjectMocks
  private FinanceSimulateBusiness financeSimulateBusiness;

  @BeforeEach
  void setup() {
    ReflectionTestUtils.setField(financeSimulateBusiness, "personCalcValue", 100L);
    ReflectionTestUtils.setField(financeSimulateBusiness, "companyCalcValue", 20L);
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testCompleteSimulate() {
    Assertions.assertEquals(100, financeSimulateBusiness.getPersonCalcValue());
    Assertions.assertEquals(20L, financeSimulateBusiness.getCompanyCalcValue());

    Mockito.when(serasaService.getDebits("123"))
        .thenReturn(Collections.singletonList(new SerasaDebits(10L)));

    Assertions.assertThrows(SecurityException.class, () -> financeSimulateBusiness.simulate(
        new SimulationData("123", 10L, 10L, 10L))
    );

    Mockito.when(serasaService.getDebits("123"))
        .thenReturn(Collections.emptyList());

    final var simulate = financeSimulateBusiness.simulate(new SimulationData("123", 10L, 10L, 10L));
    Assertions.assertNotNull(simulate);
  }

}
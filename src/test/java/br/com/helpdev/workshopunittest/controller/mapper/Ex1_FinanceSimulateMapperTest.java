package br.com.helpdev.workshopunittest.controller.mapper;

import br.com.helpdev.workshopunittest.business.model.SimulationResult;
import br.com.helpdev.workshopunittest.controller.dto.FinanceSimulateRequestDTO;
import org.junit.jupiter.api.Test;

class Ex1_FinanceSimulateMapperTest {

  // - Where are the asserts?

  @Test
  void toModel() {
    final var request = new FinanceSimulateRequestDTO();
    request.document = "123";
    request.financialValue = 1L;
    request.income = 2L;
    request.parcels = 3L;

    FinanceSimulateMapper.toModel(request);
  }

  @Test
  void toDto() {
    final var result = new SimulationResult(1L);
    FinanceSimulateMapper.toDto(result);
  }

}
package br.com.helpdev.workshopunittest.service;

import br.com.helpdev.workshopunittest.service.objects.SerasaDebits;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SerasaService {

  public List<SerasaDebits> getDebits(final String document) {

    System.out.println("Calling external call....");
    try {
      Thread.sleep(1_000);

      if (document.startsWith("111")) {
        return Collections.singletonList(new SerasaDebits(1231L));
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("...done");
    }

    return Collections.emptyList();
  }

}

package br.com.helpdev.workshopunittest.utils;

public class DocumentUtils {

  public static boolean isCpf(final String document) {
    return document != null && document.length() == 11;
  }

  public static boolean isCnpj(final String document) {
    return document != null && document.length() == 14;
  }
}

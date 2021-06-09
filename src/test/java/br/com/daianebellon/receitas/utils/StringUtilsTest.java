package br.com.daianebellon.receitas.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void isNotBlank1() {
        boolean isNotBlank = StringUtils.isNotBlank("Daiane Bellon");
        Assertions.assertTrue(isNotBlank);
    }

    @Test
    public void isNotBlank2() {
        boolean isNotBlank = StringUtils.isNotBlank("");
        Assertions.assertFalse(isNotBlank);
    }

    @Test
    public void isNotBlank3() {
        boolean isNotBlank = StringUtils.isNotBlank("       ");
        Assertions.assertFalse(isNotBlank);
    }

    @Test
    public void isNotBlank4() {
        boolean isNotBlank = StringUtils.isNotBlank("a");
        Assertions.assertTrue(isNotBlank);
    }

    @Test
    public void isBlank1() {
        boolean isBlank = StringUtils.isBlank("");
        Assertions.assertTrue(isBlank);
    }

    @Test
    public void isBlank2() {
        boolean isBlank = StringUtils.isBlank("a");
        Assertions.assertFalse(isBlank);
    }

    @Test
    public void isBlank3() {
        boolean isBlank = StringUtils.isBlank("dai bellon");
        Assertions.assertFalse(isBlank);
    }

    @Test
    public void isBlank4() {
        boolean isBlank = StringUtils.isBlank("           ");
        Assertions.assertTrue(isBlank);
    }

    @Test
    public void isBlankPassandoParametroNull() {
        boolean isBlank = StringUtils.isBlank(null);
        Assertions.assertTrue(isBlank);
    }


    @Test
    public void isNotBlankPassandoParametroNull() {
        boolean isNotBlank = StringUtils.isNotBlank(null);
        Assertions.assertFalse(isNotBlank);
    }


}

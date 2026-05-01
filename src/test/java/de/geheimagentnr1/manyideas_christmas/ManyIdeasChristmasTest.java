package de.geheimagentnr1.manyideas_christmas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ManyIdeasChristmasTest {

    @Test
    void modIdIsValid() {

        String modId = "manyideas_christmas";
        assertTrue( modId.matches( "[a-z][a-z0-9_]{1,63}" ) );
    }
}

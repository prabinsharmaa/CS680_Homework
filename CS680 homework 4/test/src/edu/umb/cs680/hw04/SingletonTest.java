package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void notNullCheck() {
        Singleton std1 = Singleton.getInstance();
        assertNotNull(std1);
    }

    @Test
    public void identityTest() {
        Singleton std1 = Singleton.getInstance();
        Singleton std2 = Singleton.getInstance();

        assertSame(std1, std2);
    }

    @Test
    public void hashCodeCheck() {
        Singleton std1 = Singleton.getInstance();
        Singleton std2 = Singleton.getInstance();

        assertEquals(std1.hashCode(), std2.hashCode());
    }
}
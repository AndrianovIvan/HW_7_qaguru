package ivanandrianv90;

import org.junit.jupiter.api.*;

public class SimpleJunitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("### @BeforeAll");
    }
    @AfterAll
    static void AfterAll() {
        System.out.println("### @AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###   @BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("###   @AfterEach");
    }

    @Test
    void firstTest() {
        System.out.println("###     @Test firstTest");
        Assertions.assertTrue(2 * 2 == 4);
    }
    @Test
    void secondTest() {
        System.out.println("###     @Test secondTest");
        Assertions.assertTrue(2 + 2 == 4);
    }
}

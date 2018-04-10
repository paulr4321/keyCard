package edu.ithaca.group1;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {

    @Test
    void menuBranchTest(){
        MainMenu testMenu = new MainMenu();
        int[] check = new int[4];

        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        check[0] = testMenu.startMainMenu(); // test security option
        System.setIn(System.in);
        in.reset();

        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        check[1] = testMenu.startMainMenu(); // test security option
        System.setIn(System.in);
        in.reset();

        in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        check[2] = testMenu.startMainMenu(); // test security option
        System.setIn(System.in);
        in.reset();

        assertEquals(check[0], 0);
        assertEquals(check[1], 1);
        assertEquals(check[2], 2);
    }
}
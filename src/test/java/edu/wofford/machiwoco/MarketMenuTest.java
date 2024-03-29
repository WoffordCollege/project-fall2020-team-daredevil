package edu.wofford.machiwoco;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import org.junit.*;
import java.util.ArrayList;
import java.util.*;


public class MarketMenuTest {
    MarketMenu m;
    private static int[] availableCards;
    private static String[] cardName;
    private static String[] cardIcon;
    private static int[] cardCost;
    private static int[] activation;

    
    @Before
    public void setup() {
        m = new MarketMenu();
        cardName = new String[] {"Wheat Field", "Ranch", "Forest"};
        cardIcon = new String[] {"       BW", "             BC", "            BG"};
        cardCost = new int[] {1, 1, 3};
        activation = new int[] {1, 2, 5};
        availableCards = new int[] {6, 6, 6};
    }
    
    @Test
    public void testPrintEmpty() {
        String s = "";
        String a = m.printMenu(0, cardName, cardIcon, cardCost, activation, availableCards);
        assertThat(a, is(s));
    }

    @Test
    public void testPrintNoLandmarks() {
        String s = "";
        s = s + "(To view details of an item, type 'view'  \n";
        s = s + "followed by the item number. For example, \n";
        s += "to view item 6, type 'view 6'.)\n";
        s += "==========================================\n";
        s += "---------        PURCHASE        ---------\n";
        s += " 1. Wheat Field        BW (1)  [1]      #6\n";
        s += " 2. Ranch              BC (1)  [2]      #6\n";
        s += " 3. Forest             BG (3)  [5]      #6\n";
        s += "---------         CANCEL         ---------\n";
        s += "99. Do nothing                            \n";
        s += "==========================================";
        String a = m.printMenu(3, cardName, cardIcon, cardCost, activation, availableCards);

        assertThat(a, is(s));
    }
    
    @Test
    public void testPrintNoMenu() {
        String s = "";
        String a = m.printMenu(0, cardName, cardIcon, cardCost, activation, availableCards);
        
        assertThat(a, is(s));
    }
    
    @Test
    public void testPrintOnlyCityHall() {
        String s = "";
        s = s + "(To view details of an item, type 'view'  \n";
        s = s + "followed by the item number. For example, \n";
        s += "to view item 6, type 'view 6'.)\n";
        s += "==========================================\n";
        s += "---------        PURCHASE        ---------\n";
        s += "---------       CONSTRUCT        ---------\n";
        s += " 1. City Hall          NT (7)  [ ]\n";
        s += "---------         CANCEL         ---------\n";
        s += "99. Do nothing                            \n";
        s += "==========================================";
        
        int[] av = new int[] {0, 0, 0};
        String a = m.printMenu(7, cardName, cardIcon, cardCost, activation, av);
        
        assertThat(a, is(s));
    }
    
    @Test
    public void testPrintFull() {
        String s = "";
        s = s + "(To view details of an item, type 'view'  \n";
        s = s + "followed by the item number. For example, \n";
        s += "to view item 6, type 'view 6'.)\n";
        s += "==========================================\n";
        s += "---------        PURCHASE        ---------\n";
        s += " 1. Wheat Field        BW (1)  [1]      #6\n";
        s += " 2. Ranch              BC (1)  [2]      #6\n";
        s += " 3. Forest             BG (3)  [5]      #6\n";
        s += "---------       CONSTRUCT        ---------\n";
        s += " 4. City Hall          NT (7)  [ ]\n";
        s += "---------         CANCEL         ---------\n";
        s += "99. Do nothing                            \n";
        s += "==========================================";
        String a = m.printMenu(7, cardName, cardIcon, cardCost, activation, availableCards);
        
        assertThat(a, is(s));
    }
    
    @Test
    public void testGetNumChoices() {
        Scanner str = new Scanner("99\n");
        
        ArrayList<Integer> chs = new ArrayList<Integer>(0);
        for (int i = 0; i < 4; i++) {
            chs.add(i + 1);
        }
        chs.add(99);
        
        assertThat(m.getChoice(str, chs), is(99));
    
    }
    
    @Test
    public void testGetInvalidPurchaseChoice() {
        Scanner str = new Scanner("5\n-1\n17\n0\n3\n");
        //ARRAY FOR NUMBER OF CHOICES
        ArrayList<Integer> chs = new ArrayList<Integer>(0);
        for (int i = 0; i < 4; i++) {
            chs.add(i + 1);
        }
        chs.add(99);
        
        assertThat(m.getChoice(str, chs), is(3));
    }
    
    @Test
    public void testListOfChoicesEmpty() {
        ArrayList<Integer> c = new ArrayList<>(0);
        int[] x = {6, 6, 6};
        int[] y = {1, 1, 3};
        int z = 0;
        assertThat(m.listOfChoices(x, y, z), is(c));
    }
    
    @Test
    public void testListOfChoicesNoCityHall() {
        ArrayList<Integer> c = new ArrayList<>(0);
        int[] x = {6, 6, 6};
        int[] y = {1, 1, 3};
        int z = 3;
        c.add(0);
        c.add(1);
        c.add(2);
        assertThat(m.listOfChoices(x, y, z), is(c));
    }
    
    @Test
    public void testListOfChoicesOnlyCityHall() {
        ArrayList<Integer> c = new ArrayList<>(0);
        int[] x = {0, 0, 0};
        int[] y = {1, 1, 3};
        int z = 7;
        c.add(1);
        assertThat(m.listOfChoices(x, y, z), is(c));
    }
}
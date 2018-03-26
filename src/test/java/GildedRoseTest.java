import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    final String expected= "OMGHAI!\n"+
            "-------- day 0 --------\n"+
            "name, sellIn, quality\n"+
            "+5 Dexterity Vest, 10, 20\n"+
            "Aged Brie, 2, 0\n"+
            "Elixir of the Mongoose, 5, 7\n"+
            "Sulfuras, Hand of Ragnaros, 0, 80\n"+
            "Sulfuras, Hand of Ragnaros, -1, 80\n"+
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 10, 49\n"+
            "Backstage passes to a TAFKAL80ETC concert, 5, 49\n"+
            "Conjured Mana Cake, 3, 6\n"+
            "\n"+
            "-------- day 1 --------\n"+
            "name, sellIn, quality\n"+
            "+5 Dexterity Vest, 9, 19\n"+
            "Aged Brie, 1, 1\n"+
            "Elixir of the Mongoose, 4, 6\n"+
            "Sulfuras, Hand of Ragnaros, 0, 80\n"+
            "Sulfuras, Hand of Ragnaros, -1, 80\n"+
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\n"+
            "Backstage passes to a TAFKAL80ETC concert, 9, 50\n"+
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\n"+
            "Conjured Mana Cake, 2, 5\n"+
            "\n";
    @Test
    public void gildedRose() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        out.println("OMGHAI!");
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose gildedRose = new GildedRose(items);
        int days=2;
        for( int i=0; i<days; i++){
            out.println("-------- day " + i + " --------");
            out.println("name, sellIn, quality");
            for(Item item : items){
                out.println(item);
            }
            out.println();
            gildedRose.updateQuality();
        }
        System.out.println(output.toString());
        assertEquals(expected, output.toString());
    }
}

package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void test_Sulfuras() {
        String name = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(name, 3, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    void test_brie() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @ParameterizedTest
    @MethodSource
    void test_Item_qualityAlready50(Item item) {
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);

    }

    private static Stream<Item> test_Item_qualityAlready50() {
        return Stream.of(new Item("Aged Brie", 3, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50));
    }

    @Test
    void test_backstage_sellIn_higherThan10Days() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 12, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(11, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 9, 8, 7, 6})
    void test_backstage_sellIn_EqualsOrLessThan10DaysAndHigherThan5(int sellIn) {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int increaseInQuality = 2;
        int quality = 10;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + increaseInQuality, app.items[0].quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 4, 3, 2, 1})
    void test_backstage_sellIn_EqualsOrLessThan5(int sellIn) {
        int increaseInQuality = 3;
        int quality = 10;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + increaseInQuality, app.items[0].quality);
    }

    @Test
    void test_backstage_sellIn_0_quality_ZERO() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_RandomItem_sellIn_0_quality_QualityDegrade2() {
        String name = "blablabla";
        Item[] items = new Item[] { new Item(name, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void test_Conjured_QualityDegrade2() {
        String name = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(name, 3, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 9, 8, 7, 6})
    void test_RandomItem_sellInHigherThan0_quality_QualityDegrade1(int sellIn) {
        String name = "blablabla";
        int quality = 10;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertEquals(quality-1, app.items[0].quality);
    }

}

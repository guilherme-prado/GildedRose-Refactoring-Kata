package com.gildedrose;

public class GoodFactory {
    static Good getInstanceOf (Item item) {
        if ("Aged Brie".equals(item.name)) {
            return new AgedBrie(item);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            return new BackstagePass(item);
        } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new Sulfura(item);
        } else if ("Conjured Mana Cake".equals(item.name)) {
            return new Conjured(item);
        }
        return new Other(item);
    }
}

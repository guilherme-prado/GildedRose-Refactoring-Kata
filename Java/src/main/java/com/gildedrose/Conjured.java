package com.gildedrose;

public class Conjured implements Good {
    Item item;

    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.quality = item.quality - 2;
        item.sellIn--;
    }
}

package com.gildedrose;

public class Other implements Good {
    private Item item;

    public Other(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.sellIn >0) {
            item.quality--;
        } else {
            item.quality = item.quality-2;
        }
        item.sellIn--;
    }
}

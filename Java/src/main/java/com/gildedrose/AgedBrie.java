package com.gildedrose;

public class AgedBrie implements Good {
    private Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality < Good.QUALITY_LIMIT) {
            item.quality++;
        }
        item.sellIn--;
    }
}

package com.gildedrose;

public class Sulfura implements Good {
    private Item item;

    public Sulfura(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.quality = 80;
    }
}

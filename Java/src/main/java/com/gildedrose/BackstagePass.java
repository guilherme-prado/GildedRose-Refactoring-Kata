package com.gildedrose;

public class BackstagePass implements Good {
    private Item item;

    public BackstagePass(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        handleQuality();
        item.sellIn--;
    }

    private void handleQuality() {
        if (item.sellIn > 0) {
            int qualityIncrease = item.quality + getQualityIncrement();
            item.quality = (qualityIncrease >= Good.QUALITY_LIMIT) ? Good.QUALITY_LIMIT : qualityIncrease;
        } else {
            item.quality = 0;
        }
    }

    int getQualityIncrement() {
        if (item.sellIn <=10 && item.sellIn > 5) {
            return 2;
        }
        if (item.sellIn <=5 && item.sellIn > 0) {
            return 3;
        }
        return 1;
    }
}

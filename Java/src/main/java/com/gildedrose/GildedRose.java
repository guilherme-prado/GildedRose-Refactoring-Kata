package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        List<Good> goods = Arrays.stream(items).map(item -> GoodFactory.getInstanceOf(item)).collect(Collectors.toList());
        goods.stream().forEach(good -> good.update());
    }
}

package training.weirdshop;

class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage Pass")) {
                decreaseQualityForOtherItems(item);
            } else {
                increaseQualityForBrieAndBP(item);
            }

            if (!item.name.equals("Gold Coin")) {
                decreaseSellInByOne(item);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage Pass")) {
                        decreaseQualityForOtherItems(item);
                    } else {
                        setQualityToZero(item);
                    }
                } else {
                   increaseQualityWhenQualityLessThan50(item);
                }
            }
        }
    }

    public void increaseQualityForBrieAndBP(Item item){
        if (item.quality < 50) {
            increaseQualityByOne(item);
            increaseQualityForBackstagePass(item);
        }
    }
    public void decreaseQualityForOtherItems(Item item){
        if (item.quality > 0 && !item.name.equals("Gold Coin")) {
            decreaseQualityByOne(item);
        }
    }

    public void increaseQualityWhenQualityLessThan50(Item item) {
        if (item.quality < 50) {
            increaseQualityByOne(item);
        }
    }

    public void increaseQualityByOne(Item item){
        item.quality = item.quality + 1;
    }

    public void decreaseQualityByOne(Item item){
        item.quality = item.quality - 1;
    }

    public void setQualityToZero(Item item){
        item.quality = 0;
    }

    public void decreaseSellInByOne(Item item){
        item.sellIn = item.sellIn - 1;
    }

    public void increaseQualityForBackstagePass(Item item){
        if (item.name.equals("Backstage Pass")) {

            if (item.sellIn < 12) {
                increaseQualityWhenQualityLessThan50(item);
            }
            if (item.sellIn < 7) {
                increaseQualityWhenQualityLessThan50(item);
            }
        }
    }

}


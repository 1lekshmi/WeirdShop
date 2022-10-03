package training.weirdshop;

class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (!isAgedBrie(item) && !isBackstagePass(item)) {
                decreaseQualityForOtherItems(item);
            } else {
                increaseQualityForBrieAndBP(item);
            }

            if (!isGoldCoin(item)) {
                decreaseSellInByOne(item);
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePass(item)) {
                        decreaseQualityForOtherItems(item);
                    } else {
                        setQualityToZero(item);
                    }
                } else {
                   increaseQualityWhenQualityLessThan50(item);
                }
            }
            checkQuality(item);
        }
    }
    public boolean isPremium(Item item){
        return item.name.contains("Premium");
    }
    public boolean isAgedBrie(Item item){
        return item.name.contains("Aged Brie");
    }
    public boolean isBackstagePass(Item item){
        return item.name.contains("Backstage Pass");
    }
    public boolean isGoldCoin(Item item){
        return item.name.contains("Gold Coin");
    }
    public void decreaseQualityByTwo(Item item){
        item.quality = item.quality - 2;
    }

    public void checkQuality(Item item){
        if(!isGoldCoin(item)){
            if (item.quality < 0){
                item.quality = 0;
            }
            if(item.quality >50){
                item.quality = 50;
            }
        }
    }

    public void increaseQualityForBrieAndBP(Item item){
        if (item.quality < 50) {
            increaseQualityByOne(item);
            increaseQualityForBackstagePass(item);
            if(isPremium(item)){
                increaseQualityByOne(item);
            }
        }
    }
    public void decreaseQualityForOtherItems(Item item){
        if (item.quality > 0 && !isGoldCoin(item) && !isPremium(item)) {
            decreaseQualityByOne(item);
        } else if (item.quality > 0 && !isGoldCoin(item) && isPremium(item)) {
            decreaseQualityByTwo(item);
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
        if (isBackstagePass(item)) {

            if (item.sellIn < 12) {
                increaseQualityWhenQualityLessThan50(item);
            }
            if (item.sellIn < 7) {
                increaseQualityWhenQualityLessThan50(item);
            }
            if(isPremium(item)){
                if (item.sellIn < 12) {
                    increaseQualityWhenQualityLessThan50(item);
                }
                if (item.sellIn < 7) {
                    increaseQualityWhenQualityLessThan50(item);
                }
            }
        }
    }

}


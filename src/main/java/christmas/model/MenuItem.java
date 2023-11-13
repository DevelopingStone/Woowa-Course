package christmas.model;

public enum MenuItem {

    // 애피타이저
    MUSHROOM_SOUP(MenuCategory.APPETIZER, "양송이수프", 6000),
    TAPAS(MenuCategory.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(MenuCategory.APPETIZER, "시저샐러드", 8000),

    // 메인
    T_BONE_STEAK(MenuCategory.MAIN, "티본스테이크", 55000),
    BBQ_RIB(MenuCategory.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(MenuCategory.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(MenuCategory.MAIN, "크리스마스파스타", 25000),

    // 디저트
    CHOCO_CAKE(MenuCategory.DESSERT, "초코케이크", 15000),
    ICE_CREAM(MenuCategory.DESSERT, "아이스크림", 5000),

    // 음료
    ZERO_COLA(MenuCategory.BEVERAGE, "제로콜라", 3000),
    RED_WINE(MenuCategory.BEVERAGE, "레드와인", 60000),
    CHAMPAGNE(MenuCategory.BEVERAGE, "샴페인", 25000);

    private final MenuCategory category;
    private final String itemName;
    private final int price;


    MenuItem(MenuCategory category, String itemName, int price) {
        this.category = category;
        this.itemName = itemName;
        this.price = price;
    }


    public static boolean isItemNameInMenu(String orderItemsKey) {
        if (orderItemsKey == null) {
            return false;
        }
        for (MenuItem menuItem : values()) {
            if (menuItem.getItemName().equals(orderItemsKey)) {
                return true;
            }
        }
        return false;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }
}

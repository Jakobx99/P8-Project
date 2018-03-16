package sw801.remindersystem.Model;
import java.util.*;
public class PreferredShopping{
    private ArrayList<int> PrefShopList;
    public enum Shops {
        Foetex(3),
        Bilka (2),
        Fakta (1),
        Spar (0)
        ;
        private final int ShopCode;

        Level(int ShopCode) {
            this.ShopCode = ShopCode;
        }

        public int getShopCode() {
            return this.ShopCode;
        }

        public void AddPrefShop(int shopCode) {
            PrefShopList.add(shopCode)
        }

        public void removeShopCode(int shopCode) {
            PrefShopList.remove(shopCode);
        }
    }
}


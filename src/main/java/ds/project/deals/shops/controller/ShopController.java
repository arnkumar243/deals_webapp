package ds.project.deals.shops.controller;

import ds.project.deals.shops.entity.Shop;
import ds.project.deals.shops.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public @ResponseBody Shop addNewUser (@RequestBody Shop shop) {

        return shopService.createShop(shop);
    }

    @GetMapping
    public @ResponseBody Iterable<Shop> getAllShops() {
        return shopService.listShops();
    }

}

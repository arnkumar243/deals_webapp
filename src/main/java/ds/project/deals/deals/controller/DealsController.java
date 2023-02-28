package ds.project.deals.deals.controller;

import ds.project.deals.deals.entity.Deals;
import ds.project.deals.deals.service.DealsService;
import ds.project.deals.fixed_deals.repository.FixedDealsRepository;
import ds.project.deals.shops.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/deals")
public class DealsController {

    @Autowired
    private DealsService dealsService;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    FixedDealsRepository fixedDealsRepository;

    @PostMapping
    public Deals addNewDeal (@RequestBody Deals deal) {
        return dealsService.createDeal(deal);
    }

    @GetMapping(path="/{id}")
    public Deals getDealById(@PathVariable int id) {
        return dealsService.getDeal(id);
    }

    @GetMapping
    public Iterable<Deals> getAllDeals() {
        return dealsService.listAllDeals();
    }

}

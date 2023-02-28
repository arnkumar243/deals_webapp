package ds.project.deals.fixed_deals.controller;

import ds.project.deals.fixed_deals.entity.FixedDeals;
import ds.project.deals.fixed_deals.repository.FixedDealsRepository;
import ds.project.deals.fixed_deals.service.FixedDealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="fixed_deals")
public class FixedDealsController {

    @Autowired
    FixedDealsService fixedDealsService;

    @PostMapping
    public FixedDeals createFixedDeals(@RequestBody FixedDeals fixedDeals) {
        return fixedDealsService.createFixedDeals(fixedDeals);
    }

    @GetMapping
    public Iterable<FixedDeals> listFixedDeals() {
        return fixedDealsService.listFixedDeals();
    }

}

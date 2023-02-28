package ds.project.deals.fixed_deals.service;

import ds.project.deals.fixed_deals.entity.FixedDeals;
import ds.project.deals.fixed_deals.repository.FixedDealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FixedDealsService {

    @Autowired
    FixedDealsRepository fixedDealsRepository;

    public FixedDeals createFixedDeals(FixedDeals fixedDeals) {
        return fixedDealsRepository.save(fixedDeals);
    }

    public Iterable<FixedDeals> listFixedDeals() {
        return fixedDealsRepository.findAll();
    }

}

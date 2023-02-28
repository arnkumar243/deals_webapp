package ds.project.deals.subscribers.controller;

import ds.project.deals.subscribers.entity.Subscriber;
import ds.project.deals.subscribers.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="subscriber")
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;

    @PostMapping
    public Subscriber addSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.addSubscriber(subscriber);
    }

    @GetMapping(path="/{id}")
    public Subscriber getSubscriber(@PathVariable Integer id) {
        return subscriberService.getSubscriberById(id);
    }

    @GetMapping()
    public Iterable<Subscriber> listSubscribers() {
        return subscriberService.listSubscribers();
    }

}
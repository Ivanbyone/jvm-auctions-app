package io.ivanbyone.backend.service;

import io.ivanbyone.backend.core.error.NotFoundException;
import io.ivanbyone.backend.core.service.RandomDataService;
import io.ivanbyone.backend.dto.input.GiftInput;
import io.ivanbyone.backend.dto.output.GiftOutput;
import io.ivanbyone.backend.model.Gift;
import io.ivanbyone.backend.repository.GiftRepository;
import io.ivanbyone.backend.service.mapper.GiftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    private final GiftMapper giftMapper;
    private final GiftRepository giftRepository;
    private final RandomDataService dataService;

    @Autowired
    public GiftService(GiftMapper giftMapper, GiftRepository giftRepository, RandomDataService dataService) {
        this.giftMapper = giftMapper;
        this.giftRepository = giftRepository;
        this.dataService = dataService;
    }

    @Cacheable(value = "all_gifts", key = "#root.methodName + #sort")
    public List<GiftOutput> findGifts(String sort) {
        List<Gift> gifts = sort.equals("desc")
                ? giftRepository.findAllByOrderBySupplyDesc()
                : giftRepository.findAllByOrderBySupplyAsc();
        return giftMapper.toList(gifts);
    }

    @Cacheable(value = "gift_by_id", key = "#id")
    public GiftOutput findGiftById(String id) {
        Gift gift = giftRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found gift with ID: " + id));
        return giftMapper.toDto(gift);
    }

    public GiftOutput giftCreation(GiftInput input) {
        Gift gift = constructGift(input);
        Gift model = giftRepository.save(gift);
        return giftMapper.toDto(model);
    }

    private Gift constructGift(GiftInput input) {
        Gift gift = new Gift();
        gift.setTitle(dataService.title());
        gift.setDescription(dataService.description());
        gift.setSupply(input.getGiftsPerRound() * input.getRounds());

        // TODO: add image field

        return gift;
    }
}

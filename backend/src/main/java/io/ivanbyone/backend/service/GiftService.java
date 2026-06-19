package io.ivanbyone.backend.service;

import io.ivanbyone.backend.core.error.AlreadyExistsException;
import io.ivanbyone.backend.core.error.NotFoundException;
import io.ivanbyone.backend.dto.output.GiftOutput;
import io.ivanbyone.backend.model.Gift;
import io.ivanbyone.backend.repository.GiftRepository;
import io.ivanbyone.backend.service.mapper.GiftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GiftService {

    private final GiftMapper giftMapper;
    private final GiftRepository giftRepository;

    @Autowired
    public GiftService(GiftMapper giftMapper, GiftRepository giftRepository) {
        this.giftMapper = giftMapper;
        this.giftRepository = giftRepository;
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
}

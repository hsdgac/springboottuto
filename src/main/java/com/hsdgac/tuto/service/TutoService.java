package com.hsdgac.tuto.service;

import com.hsdgac.tuto.dto.ItemDto;
import com.hsdgac.tuto.enitty.ItemEntity;
import com.hsdgac.tuto.mapper.TutoMapper;
import com.hsdgac.tuto.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TutoService {
    private final TutoMapper mapper;
    private final ItemRepository repository;

    @Autowired
    public TutoService(TutoMapper mapper, ItemRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public boolean registerItem(ItemDto itemDto) {
        /*HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        mapper.registerItem(paramMap);

        log.info("[registerItem] Service ...");*/

        // with JPA

        ItemEntity entity = new ItemEntity();
        entity.setId(itemDto.getId());
        entity.setName(itemDto.getName());

        repository.save(entity);

        return true;
    }

    public ItemDto getItemById(String id) {
        /*
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        HashMap<String, Object> res = mapper.findById(paramMap);

        ItemDto itemDto = new ItemDto();
        itemDto.setId((String) res.get("ID"));
        itemDto.setName((String) res.get("NAME"));

        return itemDto;*/

        // with JPA
        ItemEntity entity = repository.findById(id).get();

        ItemDto res = new ItemDto();
        res.setId(entity.getId());
        res.setName(entity.getName());

        return res;
    }
}

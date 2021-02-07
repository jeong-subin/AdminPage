package com.fast.study.controller.api;

import com.fast.study.ifs.CrudInterface;
import com.fast.study.model.network.Header;
import com.fast.study.model.network.request.ItemApiRequest;
import com.fast.study.model.network.response.ItemApiResponse;
import com.fast.study.service.ItemApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")

public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private   ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping("")// api/item
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")//api / item/1...1000
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("")// /api/item
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")//api / item/1...1000
    public Header<ItemApiResponse> delete(@PathVariable Long id) {
        return null;
    }
}

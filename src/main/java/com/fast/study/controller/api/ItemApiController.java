package com.fast.study.controller.api;

import com.fast.study.controller.CrudController;
import com.fast.study.ifs.CrudInterface;
import com.fast.study.model.entity.Item;
import com.fast.study.model.network.Header;
import com.fast.study.model.network.request.ItemApiRequest;
import com.fast.study.model.network.response.ItemApiResponse;
import com.fast.study.service.ItemApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
//CrudController  추상화 적용
@RestController
@RequestMapping("/api/item")

public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {


}

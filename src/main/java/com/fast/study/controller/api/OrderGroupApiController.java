package com.fast.study.controller.api;

import com.fast.study.controller.CrudController;
import com.fast.study.ifs.CrudInterface;
import com.fast.study.model.entity.OrderGroup;
import com.fast.study.model.network.Header;
import com.fast.study.model.network.request.OrderGroupApiRequest;
import com.fast.study.model.network.response.OrderGroupApiResponse;
import com.fast.study.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {




}

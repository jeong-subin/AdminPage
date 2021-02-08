package com.fast.study.controller.api;

import com.fast.study.controller.CrudController;
import com.fast.study.model.entity.Partner;
import com.fast.study.model.network.request.PartnerApiRequest;
import com.fast.study.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}

package com.fast.study.ifs;

import com.fast.study.model.network.Header;
import com.fast.study.model.network.request.UserApiRequest;
import com.fast.study.model.network.response.UserApiResponse;

public interface CrudInterface<Req,Res> {

    Header<Res> create(Header<Req> request);   //todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);
}

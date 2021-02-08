package com.fast.study.model.network.response;

import com.fast.study.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//request,response 예를들어 password request 평문으로 들어오고, response 암호화 해야하기때문
public class UserApiResponse {

    private Long id;
    private String account;
    private String password;
    private UserStatus status;
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private List<OrderGroupApiResponse> orderGroupApiResponseList;

}

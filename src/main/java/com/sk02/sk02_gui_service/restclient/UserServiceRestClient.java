package com.sk02.sk02_gui_service.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk02.sk02_gui_service.restclient.dto.TokenRequestDto;
import com.sk02.sk02_gui_service.restclient.dto.TokenResponseDto;
import okhttp3.*;

import java.io.IOException;

public class UserServiceRestClient {

    public static final String URL = "http://localhost:8084/user-service/api/login";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public String login(String username, String password) throws IOException {

        TokenRequestDto tokenRequestDto = new TokenRequestDto(username, password);
        //RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(tokenRequestDto));
        //TODO PROVERI POTENCIJALNO PUCANJE
        RequestBody body = RequestBody.create(objectMapper.writeValueAsString(tokenRequestDto), JSON);

        Request request = new Request.Builder()
                .url(URL + "/user/login")
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200) {
            String json = response.body().string();
            TokenResponseDto dto = objectMapper.readValue(json, TokenResponseDto.class);

            return dto.getToken();
        }

        throw new RuntimeException("Invalid username or password");
    }
}

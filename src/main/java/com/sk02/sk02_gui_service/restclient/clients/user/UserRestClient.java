package com.sk02.sk02_gui_service.restclient.clients.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk02.sk02_gui_service.restclient.dto.token.TokenRequestDto;
import com.sk02.sk02_gui_service.restclient.dto.token.TokenResponseDto;
import okhttp3.*;

import java.io.IOException;

public class UserRestClient {

    public static final String URL = "http://localhost:8084/user-service/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    //public static final String URL = "http://localhost:8081/api";

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public String login(String email, String password) throws IOException {

        TokenRequestDto tokenRequestDto = new TokenRequestDto(email, password);
        //RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(tokenRequestDto));
        //TODO PROVERI POTENCIJALNO PUCANJE
        RequestBody body = RequestBody.create(objectMapper.writeValueAsString(tokenRequestDto), JSON);

        Request request = new Request.Builder()
                .url(URL + "/users/login")
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

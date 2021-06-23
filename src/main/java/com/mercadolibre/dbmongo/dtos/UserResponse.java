package com.mercadolibre.dbmongo.dtos;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class UserResponse {
    private String id;
    private String login;

    public UserResponse() {
    }

    public UserResponse(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.login = userDTO.getLogin();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

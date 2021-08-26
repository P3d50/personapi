package com.p3d50.personapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private String message;

    public String toString(){
        return this.message;
    }
}

package bstorm.akimts.mvc.models.dto;

import bstorm.akimts.mvc.models.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClientDTO {

    private long id;
    private String username;
    private String email;
    private LocalDateTime dateNaissance;
    private int satisfaction;

    public static ClientDTO of(Client entity){
        if(entity == null)
            return null;

        return ClientDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .dateNaissance(entity.getDateNaissance())
                .satisfaction(entity.getSatisfaction())
                .build();
    }

}
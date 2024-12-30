package com.Ejercicio52.Ejercicio52;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto {
    private String name;

    private String email;

    private String url;

    private String comment;

    private Boolean agree;

    private Boolean newsletter;
}
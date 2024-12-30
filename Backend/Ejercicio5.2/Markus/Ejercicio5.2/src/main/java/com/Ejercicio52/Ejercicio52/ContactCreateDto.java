package com.Ejercicio52.Ejercicio52;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactCreateDto {
    private String email;

    private String name;

    private String surname;

    private String job;

    private String location;
}
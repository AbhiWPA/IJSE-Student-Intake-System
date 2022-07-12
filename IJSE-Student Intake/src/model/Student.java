package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String id;
    private String name;
    private String mail;
    private String contact;
    private String address;
    private String nic;
}

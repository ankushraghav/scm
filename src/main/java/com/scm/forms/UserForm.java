package com.scm.forms;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {
     private String name;
     private String email;
     private String password;
     private String about;
     private String phoneNumber;


}

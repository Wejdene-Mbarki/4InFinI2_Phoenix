package tn.esprit.InFinI_Phoenix.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults (level = AccessLevel.PRIVATE)
@Entity

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long idUser;
   private String firstName;
   private String lastName;
   private String password;
   private String address;
   private String email;
   private int numTel;
   @Enumerated TypeRole TypeRole;

}

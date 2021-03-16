package it.academy.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Data
@Table(name = "T_USER")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "U_USER_ID")
    private String userId;
    @Column(name = "U_USERNAME")
    private String username;
    @Column(name = "U_PASSWORD")
    private String password;
    @Column(name = "U_ENABLED")
    private boolean enabled;


}

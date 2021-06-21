package hoa.asm216.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String username;
    private String fullName;
    private String passwordHash;
    private int status; //1.Active 0.Deactive
    private int role; //1.admin 2.user

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Credential> credentialSet;

    public void addCredential(Credential credential) {
        if(this.credentialSet == null){
            this.credentialSet = new HashSet<>();
        }
        this.credentialSet.add(credential);
    }


}
package hoa.asm216.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Credential {

    @Id
    private String tokenKey;
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "accountId")
    private Account account;
    private long createdAt;
    private long expiredAt;
}

package hoa.asm216.repository;

import hoa.asm216.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential,String> {
}

package com.crm.project.Repository;

import com.crm.project.Model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long>{

}

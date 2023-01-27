package org.sid.billingservice.repositories;

import org.sid.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
    //la liste des productItems dans une facture
    //interface spring data => fcts
    Collection<ProductItem> findByBillId(Long id);
}

package com.bookStore.repository;

import com.bookStore.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    // You can add custom query methods here if needed
}

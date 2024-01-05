package com.bookStore.controller;

import com.bookStore.entity.Loan;
import com.bookStore.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    // Get all loans
    @GetMapping
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // Get a single loan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable(value = "id") int loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        return loan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new loan
    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanRepository.save(loan);
    }

    // Update a loan
    @PutMapping("/loans/{id}")
    @Transactional
    public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id") Long loanId, @RequestBody Loan loanDetails) {
        return loanRepository.findById(Math.toIntExact(loanId)).map(existingLoan -> {
            if (loanDetails.getDateLoan() != null) {
                existingLoan.setDateLoan(loanDetails.getDateLoan());
            }
            if (loanDetails.getMembre() != null) {
                existingLoan.setMember(loanDetails.getMembre());
            }
            if (loanDetails.getBook() != null) {
                existingLoan.setBook(loanDetails.getBook());
            }
            if (loanDetails.getDateEmprunt() != null) {
                existingLoan.setDateEmprunt(loanDetails.getDateEmprunt());
            }
            Loan updatedLoan = loanRepository.save(existingLoan);
            return ResponseEntity.ok(updatedLoan);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Delete a loan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable(value = "id") int loanId) {
        return loanRepository.findById(loanId).map(loan -> {
            loanRepository.delete(loan);
            return ResponseEntity.ok().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}


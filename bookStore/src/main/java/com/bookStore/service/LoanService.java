package com.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Loan;
import com.bookStore.repository.LoanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	public void save(Loan loan) {
		loanRepository.save(loan);
	}

	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}

	public Loan getLoanById(int id) {
		Optional<Loan> loan = loanRepository.findById(id);
		return loan.orElse(null); // Alternatively, you could throw an exception here
	}

	public void deleteById(int id) {
		loanRepository.deleteById(id);
	}
}

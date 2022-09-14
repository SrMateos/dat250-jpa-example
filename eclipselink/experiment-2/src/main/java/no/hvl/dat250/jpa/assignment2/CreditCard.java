package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer limit;
    private Integer balance;
    private Pincode pincode;

	@ManyToOne(targetEntity = Bank.class)
    private Bank bank;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Pincode getPincode() {
        return pincode;
    }

	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}

    public Bank getOwningBank() {
        return bank;
    }

	public void setOwningBank(Bank bank) {
		this.bank = bank;
	}
}

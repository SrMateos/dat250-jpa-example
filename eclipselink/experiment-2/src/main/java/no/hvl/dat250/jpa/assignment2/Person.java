package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
  
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Address> addreesses;
    private Collection<CreditCard> creditCards;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Address> getAddresses() {
        return addreesses;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }
}

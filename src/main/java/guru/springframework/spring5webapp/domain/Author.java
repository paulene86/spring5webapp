package guru.springframework.spring5webapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Author {

	public Author(){}

	public Author(String firstName, String secondtName) {
		this.firstName = firstName;
		this.secondtName = secondtName;
	}

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String secondtName;

	@ManyToMany(mappedBy = "authors")
	public Set<Book> books= new HashSet<>();



	@Override
	public String toString() {
		return "Author{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", secondtName='" + secondtName + '\'' +
			", books=" + books +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Author author = (Author) o;

		return id != null ? id.equals(author.id) : author.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

}

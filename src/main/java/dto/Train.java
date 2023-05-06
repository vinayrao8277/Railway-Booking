package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Train {
	@Id
	int Number;
	String Name;
	int Seat;
	String [] Station;
	String [] Price;
	String [] Time;
	String [] Days;
}

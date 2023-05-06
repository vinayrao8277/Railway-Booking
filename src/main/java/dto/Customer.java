package dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
int pnrNumber;
int trainNumber;
String from;
String to;
LocalDateTime tod;
boolean status;
double price;

}

package in.practice;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hellow {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		List<String> input = Arrays.asList("name;Alex", "name;Malte", "name;Danny", 
				"name;Flori", "names;Arne");
//		Output: Malte,Flori,Danny,Arne,Alex
		
		input.stream().map(i -> i.substring(i.indexOf(';')+1)).sorted(Comparator.reverseOrder()).
		forEach(k -> System.out.println(k));
		
		input.stream().map(i ->i.split(";")).flatMap(u -> Arrays.stream(u)).
		distinct().forEach(System.out::print);
		
    }
}

class Transaction {
	String date;
	int amount;

	public Transaction(String date, int amount) {
		super();
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
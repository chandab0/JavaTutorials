package main.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import resource.Customer;

public class OptionalDemo {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }

    public static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = getAll();
       return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElseThrow(()->new Exception("no customer present with this email id"));

    }

    public static void main(String[] args) throws Exception {

        Customer customer=new Customer(101, "john", "test@gmail.com", Arrays.asList("397937955", "21654725"));

        //empty
        //of
        //ofNullable

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        //Optional<String> emailOptional = Optional.of(customer.getEmail());
        //System.out.println(emailOptional);

        Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
       /* if(emailOptional2.isPresent()){
            System.out.println(emailOptional2.get());
        }*/
       // System.out.println(emailOptional2.orElse("default@email.com"));

       // System.out.println(emailOptional2.orElseThrow(()->new IllegalArgumentException("email not present")));


        System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(()->"default email..."));

        getCustomerByEmailId("pqr");
    }
}
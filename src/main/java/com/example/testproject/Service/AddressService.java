package com.example.testproject.Service;

import com.example.testproject.Entity.Address;
import com.example.testproject.Entity.Customer;
import com.example.testproject.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final CustomerService customerService;
    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public List<Address> getAddressesByCustomerId(Long customerId) {
        return addressRepository.findByCustomerId(customerId);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address addressDetails) {
        return addressRepository.findById(id)
                .map(address -> {
                    address.setType(addressDetails.getType());
                    address.setValue(addressDetails.getValue());

                    // Retrieve and set the Customer
                    Long customerId = addressDetails.getCustomer().getId();
                    Customer customer = customerService.getCustomerById(customerId)
                            .orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));

                    address.setCustomer(customer);

                    return addressRepository.save(address);
                })
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
